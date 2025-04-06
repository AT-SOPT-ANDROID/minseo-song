package org.sopt.at.presentation.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import org.sopt.at.presentation.ui.ui.theme.ATSOPTANDROIDTheme

class SignUpActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ATSOPTANDROIDTheme {
                SignUpScreen()
            }
        }
    }
}

@Composable
fun SignUpScreen(
    modifier: Modifier = Modifier
) {

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ATSOPTANDROIDTheme {
        SignUpScreen()
    }
}