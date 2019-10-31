package com.beok.bowlini.ocr

import android.Manifest
import android.graphics.Matrix
import android.os.Bundle
import android.util.Size
import android.view.Surface
import android.view.ViewGroup
import androidx.camera.core.CameraX
import androidx.camera.core.Preview
import androidx.camera.core.PreviewConfig
import com.beok.bowlini.common.base.BaseFragment
import com.beok.bowlini.common.base.BaseViewModel
import com.beok.bowlini.common.wrapper.TedPermissionWrapper
import com.beok.bowlini.ocr.databinding.FragmentOcrBinding
import com.gun0912.tedpermission.PermissionListener

class OcrFragment : BaseFragment<FragmentOcrBinding, BaseViewModel>(
    R.layout.fragment_ocr
) {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        checkCameraPermission()
    }

    private fun checkCameraPermission() {
        TedPermissionWrapper.checkPermission(
            context = requireContext(),
            listener = object : PermissionListener {
                override fun onPermissionGranted() {
                    binding.viewFinder.post { startCamera() }
                }

                override fun onPermissionDenied(deniedPermissions: MutableList<String>?) {
                    // NO OP
                }
            },
            deniedMsg = R.string.msg_permission_denied,
            permissions = *arrayOf(Manifest.permission.CAMERA)
        )
    }

    private fun startCamera() {
        val previewConfig = PreviewConfig.Builder().apply {
            setTargetResolution(Size(640, 480))
        }.build()

        val preview = Preview(previewConfig)

        preview.setOnPreviewOutputUpdateListener { previewOutput ->
            binding.viewFinder.let {
                val parent = it.parent as ViewGroup
                parent.removeView(it)
                parent.addView(it, 0)

                it.surfaceTexture = previewOutput.surfaceTexture
                updateTransform()
            }
        }

        CameraX.bindToLifecycle(
            this,
            preview
        )
    }

    private fun updateTransform() {
        val matrix = Matrix()

        binding.viewFinder.run {
            val centerX = width / 2f
            val centerY = height / 2f

            val rotationDegree = when (display.rotation) {
                Surface.ROTATION_0 -> 0
                Surface.ROTATION_90 -> 90
                Surface.ROTATION_180 -> 180
                Surface.ROTATION_270 -> 270
                else -> return
            }

            matrix.postRotate(
                -rotationDegree.toFloat(),
                centerX,
                centerY
            )
            setTransform(matrix)
        }
    }
}