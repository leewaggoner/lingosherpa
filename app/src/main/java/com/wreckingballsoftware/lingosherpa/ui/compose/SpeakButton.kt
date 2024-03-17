package com.wreckingballsoftware.lingosherpa.ui.compose

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.wreckingballsoftware.lingosherpa.R
import com.wreckingballsoftware.lingosherpa.ui.theme.dimensions

@Composable
fun SpeakButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    OutlinedButton(
        modifier = modifier,
        shape = CircleShape,
        border = BorderStroke(1.dp, Color.Gray),
        contentPadding = PaddingValues(0.dp),
        onClick = onClick,
    ) {
        Icon(
            modifier = Modifier
                .padding(MaterialTheme.dimensions.paddingSmall),
            painter = painterResource(id = R.drawable.audio),
            contentDescription = stringResource(id = R.string.play_translation),
        )
    }
}