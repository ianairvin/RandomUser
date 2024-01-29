package ru.random_user.presentation.user_screen

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity



@Composable
fun RowCellEmail(
    text1: String,
    text2: String,
    context: Context,
    bundle: Bundle,
    toastOn: MutableState<Boolean>
) {
    Row(Modifier.fillMaxWidth()){
        Box(
            Modifier
                .weight(5f)
                .fillMaxSize()) {
            Text(
                text = text1,
                Modifier
                    .padding(8.dp)

            )
        }
        Box(
            Modifier
                .weight(5f)
                .fillMaxSize()
                .clickable {
                    try {
                        val emailIntent = Intent(Intent.ACTION_SEND).apply {
                            type = "text/plain"
                            putExtra(Intent.EXTRA_EMAIL, arrayOf(text2))
                            putExtra(Intent.EXTRA_STREAM, Uri.parse("content://path/to/email/attachment"))
                        }
                        startActivity(context, emailIntent, bundle)
                    } catch(e: ActivityNotFoundException){
                        ToastErrorUserScreen(context, toastOn)
                    }
                }) {
            Text(
                color = MaterialTheme.colorScheme.secondary,
                text = text2,
                modifier = Modifier
                    .padding(8.dp)
            )
        }
    }
    HorizontalDivider(Modifier.fillMaxWidth())
}

@Composable
fun RowCellCoordinates(
    text1: String,
    text2: String,
    context: Context,
    bundle: Bundle,
    toastOn: MutableState<Boolean>
) {
    Row(Modifier.fillMaxWidth()){
        Box(
            Modifier
                .weight(5f)
                .fillMaxSize()) {
            Text(
                text = text1,
                Modifier
                    .padding(8.dp)

            )
        }
        Box(
            Modifier
                .weight(5f)
                .fillMaxSize()
                .clickable {
                    try {
                        val coordinates = text2.split(", ")
                        val location: Uri = Uri.parse("geo:" + coordinates[0] + "," + coordinates[1] + "?z=14")
                        val mapIntent = Intent(Intent.ACTION_VIEW, location)
                        startActivity(context, mapIntent, bundle)
                    } catch(e: ActivityNotFoundException){
                        ToastErrorUserScreen(context, toastOn)
                    }
                }) {
            Text(
                color = MaterialTheme.colorScheme.secondary,
                text = text2,
                modifier = Modifier
                    .padding(8.dp)
            )
        }
    }
    HorizontalDivider(Modifier.fillMaxWidth())
}

@Composable
fun RowCellPhone(
    text1: String,
    text2: String,
    context: Context,
    bundle: Bundle,
    toastOn: MutableState<Boolean>
) {
    Row(Modifier.fillMaxWidth()){
        Box(
            Modifier
                .weight(5f)
                .fillMaxSize()) {
            Text(
                text = text1,
                Modifier
                    .padding(8.dp)

            )
        }
        Box(
            Modifier
                .weight(5f)
                .fillMaxSize()
                .clickable {
                    try {
                        val callIntent = Uri.parse("tel:" + text2).let { number ->
                            Intent(Intent.ACTION_DIAL, number).also {
                                startActivity(context, it, bundle)
                            }
                        }
                    } catch(e: ActivityNotFoundException){
                        ToastErrorUserScreen(context, toastOn)
                    }
                }) {
            Text(
                color = MaterialTheme.colorScheme.secondary,
                text = text2,
                modifier = Modifier
                    .padding(8.dp)
            )
        }
    }
    HorizontalDivider(Modifier.fillMaxWidth())
}

@Composable
fun RowCell(
    text1: String,
    text2: String
) {
    Row(Modifier.fillMaxWidth()){
        Box(
            Modifier
                .weight(5f)
                .fillMaxSize()) {
            Text(
                text = text1,
                Modifier
                    .padding(8.dp)

            )
        }
        Box(
            Modifier
                .weight(5f)
                .fillMaxSize()) {
            Text(
                text = text2,
                Modifier
                    .padding(8.dp)

            )
        }
    }
    HorizontalDivider(Modifier.fillMaxWidth())
}