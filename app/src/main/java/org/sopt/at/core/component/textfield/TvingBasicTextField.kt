package org.sopt.at.core.component.textfield

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.at.ui.theme.TvingTheme
import org.sopt.at.ui.theme.TvingTheme.colors

@Composable
fun TvingBasicTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    hint: String,
    textColor: Color = Color.White,
    hintColor: Color = colors.gray300,
    maxLines: Int = 1,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    imeAction: ImeAction = ImeAction.Done,
    trailingIcon: @Composable (() -> Unit)? = null
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        maxLines = maxLines,
        singleLine = true,
        placeholder = {
            Text(
                text = hint,
                color = hintColor
            )
        },
        modifier = modifier.fillMaxWidth(),
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = colors.gray400,
            focusedContainerColor = colors.gray400,
            unfocusedIndicatorColor = Color.Transparent,
            focusedIndicatorColor = colors.gray100,
            cursorColor = Color.Blue
        ),
        visualTransformation = visualTransformation,
        keyboardOptions = KeyboardOptions(imeAction = imeAction),
        shape = RoundedCornerShape(4.dp),
        textStyle = TextStyle(color = textColor),
        trailingIcon = trailingIcon
    )
}

@Preview(showBackground = true)
@Composable
fun TvingBasicTextFieldPreview() {
    TvingTheme {
        TvingBasicTextField(
            value = "",
            onValueChange = {},
            hint = "hint"
        )
    }
}