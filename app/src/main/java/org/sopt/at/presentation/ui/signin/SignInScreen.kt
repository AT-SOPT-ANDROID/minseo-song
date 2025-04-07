package org.sopt.at.presentation.ui.signin

import android.content.Intent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.sopt.at.R
import org.sopt.at.core.component.PasswordTextField
import org.sopt.at.core.component.TvingBasicTextField
import org.sopt.at.core.component.TvingButton
import org.sopt.at.core.util.noRippleClickable
import org.sopt.at.presentation.ui.signup.SignUpActivity
import org.sopt.at.ui.theme.TvingTheme
import org.sopt.at.ui.theme.TvingTheme.colors

@Composable
fun SignInScreen(
    modifier: Modifier = Modifier,
) {
    var id by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val context = LocalContext.current

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp)
    ) {
        Text(
            text = stringResource(R.string.sign_in_title),
            color = Color.White,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(Modifier.height(20.dp))

        TvingBasicTextField(
            value = id,
            onValueChange = { id = it },
            hint = stringResource(R.string.textfield_id),
            imeAction = ImeAction.Next
        )
        Spacer(Modifier.height(20.dp))

        PasswordTextField(
            value = password,
            onValueChange = { password = it }
        )
        Spacer(Modifier.height(20.dp))

        TvingButton(
            label = stringResource(R.string.button_sign_in),
            onClick = {  },
            isDisabled = id.isEmpty() || password.isEmpty(),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(Modifier.height(40.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Text(
                text = stringResource(R.string.button_find_id),
                color = colors.gray200,
                fontSize = 16.sp
            )
            VerticalDivider(modifier = Modifier.height(22.dp), color = colors.gray300)

            Text(
                text = stringResource(R.string.button_find_password),
                color = colors.gray200,
                fontSize = 16.sp
            )
            VerticalDivider(modifier = Modifier.height(22.dp), color = colors.gray300)

            Text(
                text = stringResource(R.string.button_sign_up),
                color = colors.gray200,
                fontSize = 16.sp,
                modifier = Modifier.noRippleClickable{
                    val intent = Intent(context, SignUpActivity::class.java)
                    context.startActivity(intent)
                }
            )
        }
        Spacer(Modifier.height(40.dp))

        Text(
            text = buildAnnotatedString {
                append(stringResource(R.string.sign_in_description))
                addStyle(
                    style = SpanStyle(textDecoration = TextDecoration.Underline),
                    start = 23,
                    end = 46
                )
                addStyle(
                    style = SpanStyle(textDecoration = TextDecoration.Underline),
                    start = 49,
                    end = 54
                )
            },
            color = colors.gray300,
            fontSize = 12.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewSignInScreen() {
    TvingTheme {
        SignInScreen()
    }
}
