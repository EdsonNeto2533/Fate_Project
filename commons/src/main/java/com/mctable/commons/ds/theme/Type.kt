package com.mctable.commons.ds.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.mctable.commons.R

/**
 * Example of use
 * Text(
 *     text = "Customized TextStyle (Body1) ",
 *     style = MaterialTheme.typography.bodySmall
 * )
 */

// Set of Material typography styles to start with
val Typography = Typography(
    headlineSmall = TextStyle(
        fontSize = 20.sp,
        lineHeight = 28.sp,
        fontWeight = FontWeight(500),
        color = Color(0xFF1D1D1D),
        textAlign = TextAlign.Center,
    ),
    headlineMedium = TextStyle(
        fontSize = 24.sp,
        lineHeight = 32.sp,
        fontWeight = FontWeight(500),
        color = Color(0xFF1D1D1D),
        textAlign = TextAlign.Center,
    ),
    headlineLarge = TextStyle(
        fontSize = 28.sp,
        lineHeight = 36.sp,
        fontWeight = FontWeight(500),
        color = Color(0xFF1D1D1D),
        textAlign = TextAlign.Center,
    ),
    //token - subtitle 3
    labelSmall = TextStyle(
        fontSize = 10.sp,
        lineHeight = 16.sp,
        fontWeight = FontWeight(700),
        color = Color(0xFF1D1D1D),
    ),
    //token - subtitle 2
    labelMedium = TextStyle(
        fontSize = 12.sp,
        lineHeight = 16.sp,
        fontWeight = FontWeight(700),
        color = Color(0xFF1D1D1D),
    ),
    //token - subtitle 1
    labelLarge = TextStyle(
        fontSize = 14.sp,
        lineHeight = 16.sp,
        fontWeight = FontWeight(700),
        color = Color(0xFF1D1D1D),
    ),
    //token - body 3
    bodySmall = TextStyle(
        fontSize = 10.sp,
        lineHeight = 16.sp,
        fontWeight = FontWeight(400),
        color = Color(0xFF1D1D1D),
    ),
    //token - body 2
    bodyMedium = TextStyle(
        fontSize = 12.sp,
        lineHeight = 16.sp,
        fontWeight = FontWeight(400),
        color = Color(0xFF1D1D1D),
    ),
    //token body 1
    bodyLarge = TextStyle(
        fontSize = 14.sp,
        lineHeight = 16.sp,
        fontWeight = FontWeight(400),
        color = Color(0xFF1D1D1D),
    ),
)