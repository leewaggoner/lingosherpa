package com.wreckingballsoftware.lingosherpa.ui.mainscreen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.wreckingballsoftware.lingosherpa.R
import com.wreckingballsoftware.lingosherpa.ui.mainscreen.models.MainScreenEvent
import com.wreckingballsoftware.lingosherpa.ui.mainscreen.models.MainScreenState
import org.koin.androidx.compose.getViewModel

@Composable
fun MainScreen(viewModel: MainScreenViewModel = getViewModel()) {
    MainScreenContent(
        state = viewModel.state,
        eventHandler = viewModel::eventHandler
    )
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun MainScreenContent(
    state: MainScreenState,
    eventHandler: (MainScreenEvent) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        val keyboard = LocalSoftwareKeyboardController.current

        Column(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Text(
                text = stringResource(id = R.string.app_name),
                fontSize = 48.sp,
                fontWeight = FontWeight.Bold,
            )
            Spacer(modifier = Modifier.height(32.dp))
            OutlinedTextField(
                modifier = Modifier
                    .height(120.dp),
                value = state.textToTranslate,
                onValueChange = { text ->
                    eventHandler(MainScreenEvent.TextToTranslateChanged(text))
                },
                label = {
                    Text(
                        text = stringResource(id = R.string.text_to_translate)
                    )
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Send,
                ),
                keyboardActions = KeyboardActions(
                    onSend = {
                        eventHandler(MainScreenEvent.TranslateButtonClicked)
                        keyboard?.hide()
                    }
                ),
            )
            Spacer(modifier = Modifier.height(32.dp))
            OutlinedTextField(
                modifier = Modifier
                    .height(120.dp),
                readOnly = true,
                value = state.translatedText,
                onValueChange = { },
                label = {
                    Text(
                        text = stringResource(id = R.string.translation)
                    )
                },
            )
            Spacer(modifier = Modifier.height(16.dp))
            if (state.translatedText.isNotEmpty()) {
                OutlinedButton(
                    modifier = Modifier
                        .size(48.dp),
                    shape = CircleShape,
                    border = BorderStroke(1.dp, Color.Gray),
                    contentPadding = PaddingValues(0.dp),
                    onClick = {
                        MainScreenEvent.SpeakTranslationClicked
                    }
                ) {
                    Icon(
                        modifier = Modifier.padding(8.dp),
                        painter = painterResource(id = R.drawable.audio),
                        contentDescription = stringResource(id = R.string.play_translation)
                    )
                }
            }
        }
        Button(
            modifier = Modifier
                .width(160.dp)
                .padding(bottom = 32.dp),
            onClick = {
                eventHandler(MainScreenEvent.TranslateButtonClicked)
                keyboard?.hide()
            }
        ) {
            Text(text = stringResource(id = R.string.translate))
        }
    }

    if (state.displaySpinner) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxSize()
                .clickable(
                    indication = null,
                    interactionSource = remember { MutableInteractionSource() },
                    onClick = { },
                )
        ) {
            CircularProgressIndicator()
        }
    }
}

@Preview(name = "MainScreenContent Preview", showBackground = true)
@Composable
fun MainScreenContentPreview() {
    MainScreenContent(
        state = MainScreenState(
            translatedText = "Translated Text",
        ),
        eventHandler = { }
    )
}