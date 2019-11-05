package com.beok.bowlini.common.wrapper

import android.content.Context
import androidx.annotation.StringRes
import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.TedPermission

object TedPermissionWrapper {

    fun checkPermission(
        context: Context,
        listener: PermissionListener,
        @StringRes
        deniedMsg: Int,
        vararg permissions: String
    ) {
        TedPermission.with(context)
            .setPermissionListener(listener)
            .setDeniedMessage(deniedMsg)
            .setPermissions(*permissions)
            .check()
    }
}