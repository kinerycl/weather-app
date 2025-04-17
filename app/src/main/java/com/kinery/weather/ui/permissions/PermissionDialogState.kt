package com.kinery.weather.ui.permissions

import com.kinery.weather.R.string

sealed class PermissionDialogState {
    abstract val title: Int
    abstract val message: Int
    abstract val confirmButtonText: Int
    open val dismissButtonText: Int = string.permission_dialog_cancel

    data object AccessRequest : PermissionDialogState() {
        override val title = string.permission_dialog_request_title
        override val message = string.permission_dialog_request_message
        override val confirmButtonText = string.permission_dialog_request_confirm_text
    }

    data object PermanentlyDenied : PermissionDialogState() {
        override val title = string.permission_dialog_denied_title
        override val message = string.permission_dialog_denied_message
        override val confirmButtonText = string.permission_dialog_denied_confirm_text
    }
}