package com.kinery.weather.ui.permissions

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.kinery.weather.ui.theme.WeatherTheme

@Composable
internal fun LocationPermissionDialog(
    state: PermissionDialogState,
    onAllow: () -> Unit,
    onDismiss: () -> Unit,
    modifier: Modifier = Modifier,
) {
    AlertDialog(
        modifier = modifier,
        onDismissRequest = onDismiss,
        title = { Text(stringResource(state.title)) },
        text = {
            Text(stringResource(state.message))
        },
        confirmButton = {
            TextButton(onClick = onAllow) {
                Text(stringResource(state.confirmButtonText))
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text(stringResource(state.dismissButtonText))
            }
        }
    )
}

@Preview
@Composable
private fun LocationPermissionDialogPreview() {
    WeatherTheme {
        LocationPermissionDialog(
            state = PermissionDialogState.AccessRequest,
            onAllow = {},
            onDismiss = {},
        )
    }
}