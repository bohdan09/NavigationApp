package com.example.navigationapp.view.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import com.example.navigationapp.view.theme.spacing

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun HomeScreen(navigateToHomeFirstScreen: (value: String) -> Unit) =
    Scaffold(Modifier.fillMaxSize()) { paddingValues ->
        Box(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {
            val keyboardController = LocalSoftwareKeyboardController.current
            Column(
                modifier = Modifier.align(Alignment.Center),
                verticalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.normalSpacing)
            ) {
                Text(
                    text = "HOME"
                )
                var value by remember {
                    mutableStateOf("")
                }

                TextField(
                    value = value,
                    onValueChange = {
                        value = it
                    },
                    keyboardActions = KeyboardActions(
                        onDone = {
                            keyboardController?.hide()
                        },
                    )
                )

                Button(onClick = { navigateToHomeFirstScreen(value) }) {
                    Text(text = "Next screen")
                }
            }
        }
    }