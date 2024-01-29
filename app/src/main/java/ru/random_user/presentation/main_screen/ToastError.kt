package ru.random_user.presentation.main_screen

import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

fun ToastErrorMainScreen(
    context: Context,
    numberOfExeption: MutableState<Int>,
    toastOn: MutableState<Boolean>
) {
    val text = mutableStateOf("")
    if(numberOfExeption.value == 1){
        text.value =  "Не был загружен 1 из 20 пользователей"
    } else {
        text.value = "Не было загружено ${numberOfExeption.value} из 20 пользователей"
    }
    Toast.makeText(
        context,
        text.value,
        Toast.LENGTH_LONG,
    )
        .show()
    toastOn.value = false
    numberOfExeption.value = 0
}