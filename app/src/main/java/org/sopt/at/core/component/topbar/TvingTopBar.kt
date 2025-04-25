package org.sopt.at.core.component.topbar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import org.sopt.at.R
import org.sopt.at.core.util.noRippleClickable
import org.sopt.at.ui.theme.TvingTheme
import org.sopt.at.ui.theme.TvingTheme.colors

@Composable
fun TvingTopBar(
    profileImage: String,
    onProfileClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .padding(top = 10.dp, end = 20.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.ic_tving_logo),
            contentDescription = stringResource(R.string.app_name),
            tint = colors.red,
            modifier = Modifier.width((LocalConfiguration.current.screenWidthDp * 0.3f).dp)
        )

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_top_bar_live_tv),
                contentDescription = stringResource(R.string.top_bar_live_tv_button_content_description),
                tint = colors.gray100,
                modifier = Modifier.size(24.dp)
            )
            Spacer(Modifier.width(16.dp))


            AsyncImage(
                model = profileImage,
                contentDescription = stringResource(R.string.my_profile_content_description),
                modifier = Modifier
                    .size(24.dp)
                    .clip(shape = RoundedCornerShape(10.dp))
                    .noRippleClickable(onProfileClick)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewTvingTopBar() {
    TvingTheme {
        TvingTopBar(
            profileImage = "",
            onProfileClick = {}
        )
    }
}