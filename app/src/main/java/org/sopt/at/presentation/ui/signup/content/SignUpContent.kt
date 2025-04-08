package org.sopt.at.presentation.ui.signup.content

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.sopt.at.R
import org.sopt.at.core.component.PasswordTextField
import org.sopt.at.core.component.TvingBasicTextField
import org.sopt.at.ui.theme.TvingTheme
import org.sopt.at.ui.theme.TvingTheme.colors

@Composable
fun SignUpContent(
    id: String,
    onIdChange: (String) -> Unit,
    password: String,
    onPasswordChange: (String) -> Unit,
    type: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .padding(horizontal = 20.dp)
            .fillMaxWidth()
    ){
        Text(
            text = stringResource(R.string.sign_up_title, type),
            color = Color.White,
            fontSize = 22.sp,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
        )
        Spacer(Modifier.height(20.dp))

        when (type) {
            stringResource(R.string.textfield_id) -> {
                TvingBasicTextField(
                    value = id,
                    onValueChange = onIdChange,
                    hint = stringResource(R.string.textfield_id),
                )
                Spacer(Modifier.height(8.dp))

                Text(
                    text = stringResource(R.string.sign_up_id_description),
                    color = colors.gray300,
                    fontSize = 12.sp
                )
            }
            else -> {
                PasswordTextField(
                    value = password,
                    onValueChange = onPasswordChange
                )
                Spacer(Modifier.height(8.dp))

                Text(
                    text = stringResource(R.string.sign_up_password_description),
                    color = colors.gray300,
                    fontSize = 12.sp
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewSignUpContent() {
    TvingTheme {
        SignUpContent(
            type = "아이디",
            id = "",
            onIdChange = {},
            password = "",
            onPasswordChange = {}
        )
    }
}