package com.wreckingballsoftware.lingosherpa.ui.compose

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.wreckingballsoftware.lingosherpa.R

@Composable
fun Alert(
    modifier: Modifier = Modifier,
    title: String,
    message: String,
    onDismissRequest: () -> Unit,
    onConfirmAlert: () -> Unit,
    onDismissAlert: (() -> Unit)?,
) {
    AlertDialog(
        modifier = modifier,
        title = { Text(text = title) },
        text = { Text(text = message) },
        onDismissRequest = onDismissRequest,
        confirmButton = {
            Button(
                onClick = onConfirmAlert
            ) {
                Text(text = stringResource(id = R.string.ok))
            }
        },
        dismissButton = {
            if (onDismissAlert != null) {
                Button(
                    onClick = onDismissAlert
                ) {
                    Text(text = stringResource(id = R.string.cancel))
                }
            }
        },
    )
}