package org.sopt.at.presentation.ui.my

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import dagger.hilt.android.AndroidEntryPoint
import org.sopt.at.core.component.topbar.TvingTopBar
import org.sopt.at.presentation.ui.signin.ID_KEY
import org.sopt.at.ui.theme.TvingTheme

@AndroidEntryPoint
class MyActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val userId = intent.getStringExtra(ID_KEY).orEmpty()
        setContent {
            TvingTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        TvingTopBar()
                    }
                ) { innerPadding ->
                    MyRoute(
                        id = userId,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
