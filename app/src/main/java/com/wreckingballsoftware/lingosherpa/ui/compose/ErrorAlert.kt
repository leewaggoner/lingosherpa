package com.wreckingballsoftware.lingosherpa.ui.compose

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.wreckingballsoftware.lingosherpa.R

@Composable
fun ErrorAlert(
    modifier: Modifier = Modifier,
    message: String,
    onDismissAlert: () -> Unit,
) {
    Alert(
        modifier = modifier,
        title = stringResource(id = R.string.error),
        message = message,
        onDismissRequest = onDismissAlert,
        onConfirmAlert = onDismissAlert,
        onDismissAlert = null,
    )
}
