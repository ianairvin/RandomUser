package ru.random_user.presentation.user_screen

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.startActivity
import androidx.navigation.NavHostController
import ru.random_user.presentation.VM
import ru.random_user.presentation.main_screen.Avatar

@Composable
fun UserScreen(
    viewModel: VM,
    navController: NavHostController,
    context: Context,
    bundle: Bundle
){
    Scaffold(
        modifier = Modifier.padding(top = 16.dp, start = 16.dp, end = 16.dp),
        topBar = { TopBarUserScreen(navController) }
    ) { padding ->
        User(padding, viewModel, context, bundle)
    }
}

@Composable
fun User(
    padding: PaddingValues,
    viewModel: VM,
    context: Context,
    bundle: Bundle
    ) {
    val scrollState = rememberScrollState()

    Column(
        horizontalAlignment = Alignment.Start,
        modifier = Modifier.padding(bottom = 16.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(top = 48.dp)
                .fillMaxWidth()
        ) {
            Avatar(viewModel.pickUserEntity.value.picture, 160.dp)
        }
        Column(
            Modifier
                .fillMaxSize()
                .padding(8.dp)
                .verticalScroll(scrollState)) {
            HorizontalDivider(Modifier.fillMaxWidth())
            RowCell("ID", viewModel.pickUserEntity.value.id)
            RowCell("Национальность", viewModel.pickUserEntity.value.nat)
            RowCell("Имя", viewModel.pickUserEntity.value.name)
            RowCell("Пол", viewModel.pickUserEntity.value.gender)
            RowCell("Возраст", viewModel.pickUserEntity.value.age)
            RowCell("Адрес", viewModel.pickUserEntity.value.address)
            RowCell("Улица", viewModel.pickUserEntity.value.street)
            RowCellCoordinates("Координаты",
                viewModel.pickUserEntity.value.coordinates,
                context,
                bundle,
                viewModel.toastOnUserScreen)
            RowCellPhone("Номер телефона",
                viewModel.pickUserEntity.value.phone,
                context,
                bundle,
                viewModel.toastOnUserScreen)
            RowCellEmail("Email",
                viewModel.pickUserEntity.value.email,
                context,
                bundle,
                viewModel.toastOnUserScreen)
            RowCell("Логин", viewModel.pickUserEntity.value.login)
            RowCell("Пароль", viewModel.pickUserEntity.value.password)
        }
    }
}

