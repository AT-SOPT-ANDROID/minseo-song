package org.sopt.at.core.component

import androidx.compose.foundation.clickable
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import org.sopt.at.R
import org.sopt.at.ui.theme.TvingTheme.colors

@Composable
fun PasswordTextField(
    value: String,
    onValueChange: (String) -> Unit,
    imeAction: ImeAction = ImeAction.Done
) {
    var isPasswordVisible by remember { mutableStateOf(false) }

    TvingBasicTextField(
        value = value,
        onValueChange = onValueChange,
        hint = stringResource(R.string.textfield_password),
        visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        imeAction = imeAction,
        trailingIcon = {
            Icon(
                imageVector = if (isPasswordVisible) ImageVector.vectorResource(R.drawable.ic_password_on)
                else ImageVector.vectorResource(R.drawable.ic_password_off),
                contentDescription = stringResource(R.string.password_content_description),
                tint = colors.gray100,
                modifier = Modifier.clickable { isPasswordVisible = !isPasswordVisible }
            )
        }
    )
}