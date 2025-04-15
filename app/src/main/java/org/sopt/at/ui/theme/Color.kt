package org.sopt.at.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

val Gray100 = Color(0xFFAAAAAA)
val Gray200 = Color(0xFF848484)
val Gray300 = Color(0xFF666668)
val Gray400 = Color(0xFF2F2F2F)

@Immutable
data class TvingColors(
    val gray100: Color = Gray100,
    val gray200: Color = Gray200,
    val gray300: Color = Gray300,
    val gray400: Color = Gray400
)

val defaultTvingColors = TvingColors(
    gray100 = Gray100,
    gray200 = Gray200,
    gray300 = Gray300,
    gray400 = Gray400
)

val LocalTvingColorsProvider = staticCompositionLocalOf { defaultTvingColors }