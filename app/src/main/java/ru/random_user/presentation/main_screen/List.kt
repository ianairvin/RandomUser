package ru.random_user.presentation.main_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import ru.random_user.R
import ru.random_user.domain.entity.User
import ru.random_user.presentation.VM

@Composable
fun ListUsers(
    padding : PaddingValues,
    list: MutableState<List<User>>,
    navController: NavHostController,
    viewModel: VM
){
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding),
    ){
        itemsIndexed(list.value){ i, item ->
            Surface(
                shape = RoundedCornerShape(16.dp),
                color = colorScheme.inverseOnSurface,
                modifier = Modifier.clickable {
                    navController.navigate("user_screen") {
                        popUpTo(navController.graph.startDestinationId) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                    viewModel.pickUserId.value = item.id
                    viewModel.getUser()
                }
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth().padding(8.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Avatar(item.picture, 100.dp)
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.Start,
                        modifier = Modifier.padding(16.dp).fillMaxWidth()
                    ) {
                        Text((i + 1).toString() + ") " + item.name)
                        Text(item.address)
                        Text("телефон: " + item.phone)
                    }
                }
            }
            Spacer(modifier = Modifier.padding(8.dp))
        }
    }
}
@Composable
fun Avatar(
    url: String,
    size: Dp
){
    val picture = rememberAsyncImagePainter(url)
    if(picture != null) {
        Image(
            painter = picture,
            modifier = Modifier
                .size(size)
                .padding(8.dp)
                .clip(CircleShape)
                .fillMaxSize(),
            contentScale = ContentScale.Crop,
            contentDescription = "picture",
            alignment = Alignment.Center
        )
    } else {
        Image(
            painter = painterResource(R.drawable.template),
            modifier = Modifier
                .size(size)
                .padding(8.dp)
                .clip(CircleShape)
                .fillMaxSize(),
            alignment = Alignment.Center,
            contentDescription = "picture"
        )
    }
}