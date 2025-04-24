package org.sopt.at.ui.theme

import android.app.Activity
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val DarkColorScheme = darkColorScheme(
    background = Color.Black,
    surface = Color.Black,
    onBackground = Color.White,
    onSurface = Color.White,
    primary = Color.Red
)

object TvingTheme {
    val colors: TvingColors
        @Composable
        @ReadOnlyComposable
        get() = LocalTvingColorsProvider.current
}

@Composable
fun ProvideTvingColors(
    colors: TvingColors,
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalTvingColorsProvider provides colors,
        content = content
    )
}

@Composable
fun TvingTheme(
    content: @Composable () -> Unit
) {
    ProvideTvingColors(
        colors = defaultTvingColors
    ) {
        val view = LocalView.current
        if (!view.isInEditMode) {
            SideEffect {
                (view.context as Activity).window.run {
                    WindowCompat.getInsetsController(this, view).isAppearanceLightStatusBars = true
                }
            }
        }
        MaterialTheme(
            colorScheme = DarkColorScheme,
            content = content
        )
    }
}