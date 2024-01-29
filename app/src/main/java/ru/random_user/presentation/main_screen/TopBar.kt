package ru.random_user.presentation.main_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import ru.random_user.R
import ru.random_user.presentation.VM

@Composable
fun TopBarMainScreen(
    viewModel: VM
){
    Row(
        horizontalArrangement = Arrangement.End,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth().padding(top = 16.dp)
    ){
        IconButton(
            onClick = {
                viewModel.initUsers()
            }
        ){
            Image(
                painter = painterResource(R.drawable.autorenew),
                contentDescription = "update_list",
                colorFilter = ColorFilter.tint(colorScheme.onBackground)
            )
        }
        Spacer(modifier = Modifier.padding(bottom = 8.dp, top = 8.dp))
    }
}