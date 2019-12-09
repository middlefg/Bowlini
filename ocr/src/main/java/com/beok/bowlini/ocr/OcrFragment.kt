package com.beok.bowlini.ocr

import android.Manifest
import android.content.Context
import android.hardware.display.DisplayManager
import android.os.Bundle
import android.util.DisplayMetrics
import android.util.Rational
import androidx.camera.core.CameraX
import androidx.camera.core.Preview
import androidx.camera.core.PreviewConfig
import com.beok.bowlini.common.base.BaseFragment
import com.beok.bowlini.common.base.BaseViewModel
import com.beok.bowlini.common.wrapper.TedPermissionWrapper
import com.beok.bowlini.ocr.databinding.FragmentOcrBinding
import com.beok.bowlini.ocr.utils.AutoFitPreviewBuilder
import com.gun0912.tedpermission.PermissionListener

class OcrFragment : BaseFragment<FragmentOcrBinding, BaseViewModel>(
    R.layout.fragment_ocr
) {

    private var displayId = -1
    private var preview: Preview? = null
    private lateinit var displayManager: DisplayManager
    private val displayListener = object : DisplayManager.DisplayListener {
        override fun onDisplayChanged(displayId: Int) = Unit

        override fun onDisplayAdded(displayId: Int) = Unit

        override fun onDisplayRemoved(displayId: Int) = view?.let { view ->
            if (displayId == this@OcrFragment.displayId) {
                preview?.setTargetRotation(view.display.rotation)
            }
        } ?: Unit
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        checkCameraPermission()
    }

    override fun onDestroyView() {
        unregisterDisplayListener()
        super.onDestroyView()
    }

    private fun checkCameraPermission() {
        TedPermissionWrapper.checkPermission(
            context = requireContext(),
            listener = object : PermissionListener {
                override fun onPermissionGranted() {
                    binding.viewFinder.post { startCamera() }
                }

                override fun onPermissionDenied(deniedPermissions: MutableList<String>?) = Unit
            },
            deniedMsg = R.string.msg_permission_denied,
            permissions = *arrayOf(Manifest.permission.CAMERA)
        )
    }

    private fun startCamera() {
        registerDisplayListener()
        bindCamera()
    }

    private fun registerDisplayListener() {
        displayManager =
            requireContext().getSystemService(Context.DISPLAY_SERVICE) as DisplayManager
        displayManager.registerDisplayListener(
            displayListener,
            null
        )
    }

    private fun bindCamera() {
        val metrics = DisplayMetrics().also { binding.viewFinder.display.getRealMetrics(it) }
        val screenAspectRatio = Rational(metrics.widthPixels, metrics.heightPixels)

        val viewFinderConfig = PreviewConfig.Builder().apply {
            setLensFacing(CameraX.LensFacing.BACK)
            setTargetAspectRatio(screenAspectRatio)
            setTargetRotation(binding.viewFinder.display.rotation)
        }.build()

        preview = AutoFitPreviewBuilder.getPreview(
            config = viewFinderConfig,
            viewFinder = binding.viewFinder
        )

        CameraX.bindToLifecycle(viewLifecycleOwner, preview)
    }

    private fun unregisterDisplayListener() {
        displayManager.unregisterDisplayListener(displayListener)
    }
}