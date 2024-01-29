package ru.random_user.presentation

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.core.os.bundleOf
import androidx.core.view.WindowCompat
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint
import ru.random_user.ui.theme.RandomUserTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)

        val viewModel by viewModels<VM>()

        setContent {
            RandomUserTheme {
                UiController(isSystemInDarkTheme())
                val context = LocalContext.current
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    Navigation(context, viewModel, navController, bundleOf())

                    val sharedPreferences = getSharedPreferences("hasVisited", Context.MODE_PRIVATE)
                    val hasVisited = sharedPreferences.getBoolean("hasVisited", false)
                    if(!hasVisited){
                        val e = sharedPreferences.edit()
                        e.putBoolean("hasVisited", true)
                        e.commit()

                        viewModel.initUsers()
                    }

                }
            }
        }
    }
}


@Composable
fun UiController(darkTheme: Boolean){
    val systemUiController = rememberSystemUiController()
    SideEffect {
        systemUiController.setStatusBarColor(color = Color.Transparent)
        systemUiController.statusBarDarkContentEnabled = !darkTheme
        systemUiController.setNavigationBarColor(color =
        if (darkTheme) ru.random_user.color.backgroundDark
        else ru.random_user.color.backgroundLight)
        systemUiController.navigationBarDarkContentEnabled = !darkTheme
    }
}