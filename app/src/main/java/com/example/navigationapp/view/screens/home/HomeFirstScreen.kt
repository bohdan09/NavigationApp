package com.example.navigationapp.view.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.navigationapp.view.theme.spacing

@Composable
fun HomeFirstScreen(
    receivedValue: String,
    onBackClick: () -> Unit
) = Scaffold(Modifier.fillMaxSize()) { paddingValues ->
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
    ) {
        Column(
            modifier = Modifier.align(Alignment.Center),
            verticalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.normalSpacing)
        ) {
            Text(text = "Received value: $receivedValue")
            Button(onClick = { onBackClick() }) {
                Text(text = "Back")
            }
        }

    }
}