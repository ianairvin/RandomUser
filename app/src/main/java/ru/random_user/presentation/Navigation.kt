package ru.random_user.presentation

import android.content.Context
import android.os.Bundle
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ru.random_user.presentation.main_screen.MainScreen
import ru.random_user.presentation.user_screen.UserScreen

@Composable
fun Navigation(
    context: Context,
    viewModel: VM,
    navController: NavHostController,
    bundle: Bundle
){
    NavHost(navController = navController, startDestination = "main_screen"){
        composable("main_screen"){
            MainScreen(context, viewModel, navController)
        }
        composable("user_screen"){
            UserScreen(viewModel, navController, context, bundle)
        }
    }
}