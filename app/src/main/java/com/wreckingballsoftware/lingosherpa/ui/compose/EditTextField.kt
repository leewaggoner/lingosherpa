package com.wreckingballsoftware.lingosherpa.ui.compose

import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.wreckingballsoftware.lingosherpa.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditTextField(
    value: String,
    valueChanged: (String) -> Unit,
    modifier: Modifier = Modifier,
    label: String = "",
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
) {
    OutlinedTextField(
        modifier = modifier,
        value = value,
        onValueChange = valueChanged,
        label = { Text(text = label) },
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
    )
}