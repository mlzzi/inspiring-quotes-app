package com.example.inspiringquotes.ui.theme

import android.annotation.SuppressLint
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

@SuppressLint("ConflictingOnColor")
private val DarkColorPalette = darkColors(
    background = SlightBlack,
    surface = SoftBlack,
    onSurface = SoftWhite,
    primary = SoftBlack,
    secondary = DarkPink
)

private val LightColorPalette = lightColors(
    background = SoftWhite,
    surface = Grey,
    onSurface = SoftBlack,
    primary = Pink,
    secondary = DarkPink
)

@Composable
fun InspiringQuotesTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}