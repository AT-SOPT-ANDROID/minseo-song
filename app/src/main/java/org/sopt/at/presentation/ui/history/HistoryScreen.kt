package org.sopt.at.presentation.ui.history

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import org.sopt.at.ui.theme.TvingTheme

@Composable
fun HistoryRoute(
    padding: PaddingValues
) {
    HistoryScreen(padding = padding)
}

@Composable
private fun HistoryScreen(
    padding: PaddingValues
) {
    Column(
        modifier = Modifier.fillMaxSize()
            .padding(padding),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "History Screen"
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewHistoryScreen() {
    TvingTheme {
        HistoryScreen(
            padding = PaddingValues()
        )
    }
}