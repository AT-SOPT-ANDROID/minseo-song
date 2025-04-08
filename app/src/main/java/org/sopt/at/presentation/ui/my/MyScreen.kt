package org.sopt.at.presentation.ui.my

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import org.sopt.at.R
import org.sopt.at.core.component.button.TvingButton
import org.sopt.at.core.util.noRippleClickable
import org.sopt.at.ui.theme.TvingTheme
import org.sopt.at.ui.theme.TvingTheme.colors

@Composable
fun MyRoute(
    id: String,
    navigateSignIn: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: MyViewModel = hiltViewModel(),
) {
    val profileImage by viewModel.profileImage.collectAsState()

    MyScreen(
        id = id,
        profileImage = profileImage,
        onLogoutClick = navigateSignIn,
        modifier = modifier
    )
}

@Composable
fun MyScreen(
    id: String,
    profileImage: String,
    onLogoutClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = Modifier.padding(vertical = 20.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                AsyncImage(
                    model = profileImage,
                    contentDescription = stringResource(R.string.my_profile_description),
                    modifier = Modifier
                        .size(90.dp)
                        .clip(shape = RoundedCornerShape(10.dp))
                )

                Text(
                    text = id,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(start = 20.dp)
                )

                Icon(
                    painter = painterResource(id = R.drawable.baseline_mode_24),
                    contentDescription = stringResource(R.string.my_profile_edit_button),
                    tint = colors.gray200,
                    modifier = Modifier
                        .padding(start = 4.dp)
                        .noRippleClickable {}
                )
            }

            TvingButton(
                label = stringResource(R.string.my_profile_change_button),
                onClick = {}
            )
        }

        TvingButton(
            label = stringResource(R.string.my_logout_button),
            onClick = onLogoutClick,
            fontSize = 14,
            padding = 8,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewMyScreen() {
    TvingTheme {
        MyScreen(
            id = "밍소",
            profileImage = "",
            onLogoutClick = {}
        )
    }
}