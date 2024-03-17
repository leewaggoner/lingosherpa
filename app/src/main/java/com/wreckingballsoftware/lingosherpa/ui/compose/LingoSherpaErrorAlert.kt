package com.wreckingballsoftware.lingosherpa.ui.compose

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.wreckingballsoftware.lingosherpa.R

@Composable
fun LingoSherpaErrorAlert(
    message: String,
    onDismissAlert: () -> Unit,
) {
    LingoSherpaAlert(
        title = stringResource(id = R.string.error),
        message = message,
        onDismissRequest = onDismissAlert,
        onConfirmAlert = onDismissAlert,
        onDismissAlert = null,
    )
}
