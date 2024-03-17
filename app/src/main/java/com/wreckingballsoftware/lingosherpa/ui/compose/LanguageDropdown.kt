package com.wreckingballsoftware.lingosherpa.ui.compose

import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.wreckingballsoftware.lingosherpa.R
import com.wreckingballsoftware.lingosherpa.ui.mainscreen.models.MainScreenEvent
import com.wreckingballsoftware.lingosherpa.ui.mainscreen.models.MainScreenState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LanguageDropdown(
    modifier: Modifier = Modifier,
    state: MainScreenState,
    eventHandler: (MainScreenEvent) -> Unit
) {
    ExposedDropdownMenuBox(
        modifier = modifier,
        expanded = state.dropdownExpanded,
        onExpandedChange = { newValue ->
            eventHandler(MainScreenEvent.ExpandedChanged(expanded = newValue))
        },
    ) {
        OutlinedTextField(
            modifier = Modifier.menuAnchor(),
            readOnly = true,
            value = state.selectedLanguage?.displayLanguage ?: "",
            onValueChange = { },
            label = {
                Text(
                    text = stringResource(id = R.string.target_language_label),
                )
            },
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(expanded = state.dropdownExpanded)
            },
            colors = ExposedDropdownMenuDefaults.textFieldColors(),
        )
        ExposedDropdownMenu(
            expanded = state.dropdownExpanded,
            onDismissRequest = { eventHandler(MainScreenEvent.DismissDropdown) },
        ) {
            state.languages.forEach { selectionOption ->
                DropdownMenuItem(
                    text = { Text(text = selectionOption.displayName) },
                    onClick = {
                        eventHandler(
                            MainScreenEvent.LanguageSelected(
                                language = selectionOption
                            )
                        )
                    },
                    contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding,
                )
            }
        }
    }
}

@Preview(name = "CurrencyDropdown", showBackground = true)
@Composable
fun LanguageDropdownPreview() {
    LanguageDropdown(
        state = MainScreenState(),
        eventHandler = { }
    )
}
