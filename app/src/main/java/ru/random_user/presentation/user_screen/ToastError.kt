package ru.random_user.presentation.user_screen

import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.MutableState

fun ToastErrorUserScreen(
    context: Context,
    toastOn: MutableState<Boolean>
) {
    Toast.makeText(
        context,
        "Невозможно открыть приложение",
        Toast.LENGTH_LONG,
    )
        .show()
    toastOn.value = false
}