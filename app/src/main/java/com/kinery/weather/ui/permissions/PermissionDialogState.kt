package com.kinery.weather.ui.permissions

// TODO: move text to string res
// TODO: create sealed class, abstract val, & open val notes
sealed class PermissionDialogState {
    abstract val title: String
    abstract val message: String
    abstract val confirmButtonText: String
    open val dismissButtonText: String = "Cancel"

    data object FirstTime : PermissionDialogState() {
        override val title = "Allow Location Access?"
        override val message = "To give you accurate, real-time weather updates for your area, we need access to your device’s location."
        override val confirmButtonText = "Allow"
    }

    data object PermanentlyDenied : PermissionDialogState() {
        override val title = "Location Access Disabled"
        override val message = "It looks like location access has been turned off. To show local weather, please enable location permissions in your settings."
        override val confirmButtonText = "Open Settings"
    }
}