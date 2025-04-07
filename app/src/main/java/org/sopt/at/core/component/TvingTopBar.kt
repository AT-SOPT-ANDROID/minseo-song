package org.sopt.at.core.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import org.sopt.at.R
import org.sopt.at.ui.theme.TvingTheme
import org.sopt.at.ui.theme.TvingTheme.colors

@Composable
fun TvingTopBar(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
    ){
        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.baseline_arrow_back_24),
            contentDescription = stringResource(R.string.top_bar_back_button_content_description),
            tint = colors.gray100
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewTvingTopBar() {
    TvingTheme {
        TvingTopBar()
    }
}