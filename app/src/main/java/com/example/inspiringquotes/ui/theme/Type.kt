package com.example.inspiringquotes.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.inspiringquotes.R

val Montserrat = FontFamily(
    Font(R.font.montserrat_medium, FontWeight.Normal),
    Font(R.font.montserrat_light, FontWeight.Normal)
)

// Set of Material typography styles to start with
val Typography = Typography(
    defaultFontFamily = Montserrat,
    h1 = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 24.sp
    ),
    h2 = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),
    body1 = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
)