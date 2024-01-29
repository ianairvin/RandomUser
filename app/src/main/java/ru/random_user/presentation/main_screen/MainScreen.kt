package ru.random_user.presentation.main_screen

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import ru.random_user.presentation.VM

@Composable
fun MainScreen(
    context: Context,
    viewModel: VM,
    navController: NavHostController
) {
    if(viewModel.update.value){
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            /*
            Image(
                painter = painterResource(R.drawable.autorenew),
                modifier = Modifier.size(20.dp),
                contentDescription = "update_list",
                colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onBackground)
            )
            Text(text = "Обновление")*/
            CircularProgressIndicator(
                modifier = Modifier.size(36.dp),
                strokeWidth = 4.dp,
            )
        }
    } else {
        Scaffold(
            modifier = Modifier.padding(top = 16.dp, start = 16.dp, end = 16.dp),
            topBar = { TopBarMainScreen(viewModel) }
        ) { padding ->
            ListUsers(padding, viewModel.list, navController, viewModel)
            if (viewModel.toastOnMainScreen.value) {
                ToastErrorMainScreen(
                    context,
                    viewModel.numberOfExeption,
                    viewModel.toastOnMainScreen
                )
            }
        }
    }
}