package com.beok.bowlini.ocr.utils

import android.content.Context
import android.graphics.Matrix
import android.hardware.display.DisplayManager
import android.util.Log
import android.util.Size
import android.view.*
import androidx.camera.core.Preview
import androidx.camera.core.PreviewConfig
import java.lang.ref.WeakReference
import kotlin.math.roundToInt

/**
 * 참고 [https://github.com/android/camera-samples/tree/master/CameraXBasic]
 */
class AutoFitPreviewBuilder private constructor(
    private val config: PreviewConfig,
    private val viewFinderRef: WeakReference<TextureView>
) {
    private var bufferRotation: Int = 0
    private var bufferDimens: Size = Size(0, 0)

    private var viewFinderRotation: Int? = null
    private var viewFinderDimens: Size = Size(0, 0)
    private var viewFinderDisplay: Int = -1

    private lateinit var displayManager: DisplayManager
    private val displayListener = object : DisplayManager.DisplayListener {
        override fun onDisplayAdded(displayId: Int) = Unit
        override fun onDisplayRemoved(displayId: Int) = Unit
        override fun onDisplayChanged(displayId: Int) {
            val viewFinder = viewFinderRef.get() ?: return
            if (displayId == viewFinderDisplay) {
                val display = displayManager.getDisplay(displayId)
                val rotation = getDisplaySurfaceRotation(display)
                updateTransform(viewFinder, rotation, bufferDimens, viewFinderDimens)
            }
        }
    }

    fun getPreview(): Preview {
        val viewFinder = viewFinderRef.get() ?: error("Invalid reference to view finder used")

        viewFinderDisplay = viewFinder.display.displayId
        viewFinderRotation = getDisplaySurfaceRotation(viewFinder.display) ?: 0

        val preview = Preview(config)
        preview.onPreviewOutputUpdateListener = Preview.OnPreviewOutputUpdateListener {
            val previewFinder =
                viewFinderRef.get() ?: return@OnPreviewOutputUpdateListener
            Log.d(
                TAG,
                "Preview output changed. Size: ${it.textureSize}. Rotation: ${it.rotationDegrees}"
            )

            val parent = previewFinder.parent as ViewGroup
            parent.removeView(previewFinder)
            parent.addView(previewFinder, 0)

            previewFinder.surfaceTexture = it.surfaceTexture

            bufferRotation = it.rotationDegrees
            val rotation = getDisplaySurfaceRotation(previewFinder.display)
            updateTransform(previewFinder, rotation, it.textureSize, viewFinderDimens)
        }

        viewFinder.addOnLayoutChangeListener { view, left, top, right, bottom, _, _, _, _ ->
            val previewFinder = view as TextureView
            val newViewFinderDimens = Size(right - left, bottom - top)
            Log.d(TAG, "View finder layout changed. Size: $newViewFinderDimens")
            val rotation = getDisplaySurfaceRotation(previewFinder.display)
            updateTransform(previewFinder, rotation, bufferDimens, newViewFinderDimens)
        }

        displayManager =
            viewFinder.context.getSystemService(Context.DISPLAY_SERVICE) as DisplayManager
        displayManager.registerDisplayListener(displayListener, null)

        viewFinder.addOnAttachStateChangeListener(object : View.OnAttachStateChangeListener {
            override fun onViewAttachedToWindow(view: View?) =
                displayManager.registerDisplayListener(displayListener, null)

            override fun onViewDetachedFromWindow(view: View?) =
                displayManager.unregisterDisplayListener(displayListener)
        })
        return preview
    }

    private fun updateTransform(
        textureView: TextureView?, rotation: Int?, newBufferDimens: Size,
        newViewFinderDimens: Size
    ) {
        textureView ?: return

        if (rotation == viewFinderRotation &&
            newBufferDimens == bufferDimens &&
            newViewFinderDimens == viewFinderDimens
        ) {
            return
        }

        if (rotation == null) {
            return
        } else {
            viewFinderRotation = rotation
        }

        if (newBufferDimens.width == 0 || newBufferDimens.height == 0) {
            return
        } else {
            bufferDimens = newBufferDimens
        }

        if (newViewFinderDimens.width == 0 || newViewFinderDimens.height == 0) {
            return
        } else {
            viewFinderDimens = newViewFinderDimens
        }

        val matrix = Matrix()
        Log.d(
            TAG, "Applying output transformation.\n" +
                    "View finder size: $viewFinderDimens.\n" +
                    "Preview output size: $bufferDimens\n" +
                    "View finder rotation: $viewFinderRotation\n" +
                    "Preview output rotation: $bufferRotation"
        )

        val centerX = viewFinderDimens.width / 2f
        val centerY = viewFinderDimens.height / 2f

        matrix.postRotate(-viewFinderRotation!!.toFloat(), centerX, centerY)

        val bufferRatio = bufferDimens.height / bufferDimens.width.toFloat()

        val scaledWidth: Int
        val scaledHeight: Int
        if (viewFinderDimens.width > viewFinderDimens.height) {
            scaledHeight = viewFinderDimens.width
            scaledWidth = (viewFinderDimens.width * bufferRatio).roundToInt()
        } else {
            scaledHeight = viewFinderDimens.height
            scaledWidth = (viewFinderDimens.height * bufferRatio).roundToInt()
        }

        val xScale = scaledWidth / viewFinderDimens.width.toFloat()
        val yScale = scaledHeight / viewFinderDimens.height.toFloat()

        matrix.preScale(xScale, yScale, centerX, centerY)

        textureView.setTransform(matrix)
    }

    private fun getDisplaySurfaceRotation(display: Display?) = when (display?.rotation) {
        Surface.ROTATION_0 -> 0
        Surface.ROTATION_90 -> 90
        Surface.ROTATION_180 -> 180
        Surface.ROTATION_270 -> 270
        else -> null
    }

    companion object {
        private val TAG = AutoFitPreviewBuilder::class.java.simpleName

        fun getPreview(config: PreviewConfig, viewFinder: TextureView) =
            AutoFitPreviewBuilder(config, WeakReference(viewFinder)).getPreview()
    }
}