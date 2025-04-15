package org.sopt.at.core.component.topbar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.at.R
import org.sopt.at.core.util.noRippleClickable
import org.sopt.at.ui.theme.TvingTheme
import org.sopt.at.ui.theme.TvingTheme.colors

@Composable
fun TvingTopBar(
    modifier: Modifier = Modifier,
    onBackClicked: () -> Unit = {},
    isMyPage: Boolean = false
) {
    Row(
        modifier = modifier
            .padding(20.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.ic_arrow_back_24),
            contentDescription = stringResource(R.string.top_bar_back_button_content_description),
            tint = colors.gray100,
            modifier = Modifier.noRippleClickable(onBackClicked)
        )

        if (isMyPage){
            Row(
                verticalAlignment = Alignment.CenterVertically
            ){
                Icon(
                    painter = painterResource(id = R.drawable.ic_notifications_none_24),
                    contentDescription = stringResource(R.string.top_bar_notification_button_content_description),
                    tint = colors.gray100,
                    modifier = Modifier.noRippleClickable {}
                )
                Spacer(Modifier.width(10.dp))

                Icon(
                    painter = painterResource(id = R.drawable.ic_setting_24),
                    contentDescription = stringResource(R.string.top_bar_setting_button_content_description),
                    tint = colors.gray100,
                    modifier = Modifier
                        .noRippleClickable {}
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewTvingTopBar() {
    TvingTheme {
        TvingTopBar(
            isMyPage = true
        )
    }
}