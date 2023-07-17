package com.example.navigationapp.view.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class Spacing(
    val smallSpacing: Dp = 4.dp,
    val halfNormalSpacing: Dp = 8.dp,
    val normalSpacing: Dp = 16.dp,
    val smallMediumSpacing: Dp = 24.dp,
    val mediumSpacing: Dp = 32.dp,
    val baseMediumSpacing: Dp = 42.dp,
)

val MaterialTheme.spacing: Spacing
    @Composable
    @ReadOnlyComposable
    get() = LocalSpacing.current

val LocalSpacing = staticCompositionLocalOf { Spacing() }
