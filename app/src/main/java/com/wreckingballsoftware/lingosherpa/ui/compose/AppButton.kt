package com.wreckingballsoftware.lingosherpa.ui.compose

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.wreckingballsoftware.lingosherpa.R
import com.wreckingballsoftware.lingosherpa.ui.mainscreen.models.MainScreenEvent
import com.wreckingballsoftware.lingosherpa.ui.theme.dimensions

@Composable
fun AppButton(
    text: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    Button(
        modifier = modifier.then(
            Modifier
            .width(MaterialTheme.dimensions.buttonWidth)
        ),
        onClick = onClick
    ) {
        Text(text = text)
    }
}