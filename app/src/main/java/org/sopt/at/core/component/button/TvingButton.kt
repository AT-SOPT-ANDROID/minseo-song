package org.sopt.at.core.component.button

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.sopt.at.core.util.noRippleClickable
import org.sopt.at.ui.theme.TvingTheme
import org.sopt.at.ui.theme.TvingTheme.colors

@Composable
fun TvingButton(
    label: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    fontSize: Int = 12,
    padding: Int = 4
) {
    Box(
        modifier = modifier
            .noRippleClickable(onClick)
            .border(width = 1.dp, color = colors.gray100, shape = RoundedCornerShape(4.dp))
            .padding(vertical = padding.dp, horizontal = 8.dp)
    ) {
        Text(
            text = label,
            fontSize = fontSize.sp,
            color = colors.gray100,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewTvingButton() {
    TvingTheme {
        TvingButton(
            label = "프로필 전환",
            onClick = {}
        )
    }
}