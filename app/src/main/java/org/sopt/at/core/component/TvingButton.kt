package org.sopt.at.core.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.sopt.at.R
import org.sopt.at.core.util.noRippleClickable
import org.sopt.at.ui.theme.TvingTheme

@Composable
fun TvingButton(
    label: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    isDisabled: Boolean = false,
) {
    val backgroundColor: Color
    val textColor: Color

    when (isDisabled) {
        true -> {
            backgroundColor = Color.DarkGray
            textColor = Color.Gray
        }

        else -> {
            backgroundColor = Color.Red
            textColor = Color.White
        }
    }

    Box(
        modifier = modifier
            .noRippleClickable(onClick)
            .fillMaxWidth()
            .background(color = backgroundColor, shape = RoundedCornerShape(4.dp))
            .padding(vertical = 14.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = label,
            color = textColor,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewTvingButton() {
    TvingTheme {
        TvingButton(
            label = stringResource(R.string.button_sign_in),
            onClick = {}
        )
    }
}