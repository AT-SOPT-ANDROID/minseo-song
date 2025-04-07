package org.sopt.at.presentation.ui.signin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import org.sopt.at.core.component.TvingTopBar
import org.sopt.at.ui.theme.TvingTheme

const val ID_KEY = "id"
const val PASSWORD_KEY = "password"

class SignInActivity : ComponentActivity() {
    private var id: String = ""
    private var password: String = ""

    val resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){result ->
        if(result.resultCode == RESULT_OK){
            id = result.data?.getStringExtra(ID_KEY) ?: ""
            password = result.data?.getStringExtra(PASSWORD_KEY) ?: ""
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val coroutine = rememberCoroutineScope()
            val snackbarHostState = remember { SnackbarHostState() }

            TvingTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        TvingTopBar()
                    }
                ){ innerPadding ->
                    SignInScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
