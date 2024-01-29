package ru.random_user.presentation.user_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import ru.random_user.R

@Composable
fun TopBarUserScreen(
    navController: NavHostController
){
    Row(
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth().padding(top = 16.dp)
    ){
        IconButton(
            onClick = {
                navController.navigate("main_screen") {
                    popUpTo(navController.graph.startDestinationId) {
                        saveState = true
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            },
        ){
            Image(
                painter = painterResource(R.drawable.back),
                contentDescription = "back_to_main_screen",
                colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onBackground)
            )
        }
        Spacer(modifier = Modifier.padding(bottom = 8.dp, top = 8.dp))
    }
}