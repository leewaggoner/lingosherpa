package com.wreckingballsoftware.lingosherpa.ui.mainscreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import com.wreckingballsoftware.lingosherpa.R
import com.wreckingballsoftware.lingosherpa.ui.compose.AppButton
import com.wreckingballsoftware.lingosherpa.ui.compose.EditTextField
import com.wreckingballsoftware.lingosherpa.ui.compose.ErrorAlert
import com.wreckingballsoftware.lingosherpa.ui.compose.LanguageDropdown
import com.wreckingballsoftware.lingosherpa.ui.compose.LoadingSpinner
import com.wreckingballsoftware.lingosherpa.ui.compose.SpeakButton
import com.wreckingballsoftware.lingosherpa.ui.mainscreen.models.MainScreenEvent
import com.wreckingballsoftware.lingosherpa.ui.mainscreen.models.MainScreenState
import com.wreckingballsoftware.lingosherpa.ui.theme.customTypography
import com.wreckingballsoftware.lingosherpa.ui.theme.dimensions
import org.koin.androidx.compose.getViewModel

@Composable
fun MainScreen(viewModel: MainScreenViewModel = getViewModel()) {
    MainScreenContent(
        state = viewModel.state,
        eventHandler = viewModel::eventHandler
    )
}

@Composable
fun MainScreenContent(
    state: MainScreenState,
    eventHandler: (MainScreenEvent) -> Unit
) {
    Column(
        modifier = Modifier
            .padding(MaterialTheme.dimensions.padding)
            .fillMaxSize(),
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
                style = MaterialTheme.customTypography.headline,
            )
            Spacer(modifier = Modifier.height(MaterialTheme.dimensions.spaceMedium))
            LanguageDropdown(state = state, eventHandler = eventHandler)
            Spacer(modifier = Modifier.height(MaterialTheme.dimensions.spaceSmall))
            EditTextField(
                modifier = Modifier
                    .height(MaterialTheme.dimensions.textFieldHeight),
                value = state.textToTranslate,
                valueChanged = { text ->
                    eventHandler(MainScreenEvent.TextToTranslateChanged(text))
                },
                label = stringResource(id = R.string.text_to_translate),
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Send,
                ),
                keyboardActions = KeyboardActions(
                    onSend = {
                        eventHandler(MainScreenEvent.TranslateButtonClicked)
                        keyboard?.hide()
                    }
                ),
            )
            Spacer(modifier = Modifier.height(MaterialTheme.dimensions.spaceSmall))
            EditTextField(
                modifier = Modifier
                    .height(MaterialTheme.dimensions.textFieldHeight),
                value = state.translatedText,
                valueChanged = { },
                label = stringResource(id = R.string.translation)
            )
            Spacer(modifier = Modifier.height(MaterialTheme.dimensions.spaceSmall))
            SpeakButton(modifier = Modifier.size(MaterialTheme.dimensions.speechButtonSize)) {
                eventHandler(MainScreenEvent.SpeakTranslationClicked)
            }
        }
        AppButton(
            modifier = Modifier
                .padding(bottom = MaterialTheme.dimensions.spaceMedium),
            text = stringResource(id = R.string.translate)
        ) {
            eventHandler(MainScreenEvent.TranslateButtonClicked)
            keyboard?.hide()

        }
    }

    if (state.displaySpinner) {
        LoadingSpinner()
    }

    if (state.errorMessage != null) {
        ErrorAlert(message = state.errorMessage) {
            eventHandler(MainScreenEvent.DismissError)
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