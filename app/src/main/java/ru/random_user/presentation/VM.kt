package ru.random_user.presentation

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.random_user.domain.entity.User
import ru.random_user.domain.use_case.DeleteUsersUseCase
import ru.random_user.domain.use_case.GetAllUsersUseCase
import ru.random_user.domain.use_case.GetOneUserUseCase
import ru.random_user.domain.use_case.GetUserFromApiUseCase
import javax.inject.Inject

@HiltViewModel
class VM @Inject constructor(
    private val getUserFromApi: GetUserFromApiUseCase,
    private val getAllUsers: GetAllUsersUseCase,
    private val getOneUser: GetOneUserUseCase,
    private val deleteUsers: DeleteUsersUseCase
) : ViewModel() {

    val list = mutableStateOf<List<User>>(emptyList())
    val toastOnMainScreen = mutableStateOf(false)
    val toastOnUserScreen = mutableStateOf(false)
    val numberOfExeption = mutableStateOf(0)
    val update = mutableStateOf(false)
    val pickUserId = mutableStateOf("")
    val pickUserEntity = mutableStateOf(
        User("","","","","","","","","","","", "", ""))

    fun initUsers() = viewModelScope.launch(Dispatchers.IO) {
        deleteUsers()
        list.value = emptyList()
        update.value = true
        for(i in 1..20) {
            getUserFromApi().onSuccess { }
            .onFailure {
                numberOfExeption.value++
            }
        }
        if(numberOfExeption.value != 0) { toastOnMainScreen.value = true }
        getUsersForList()
        update.value = false
    }

    private fun getUsersForList() = viewModelScope.launch{
        list.value = getAllUsers()
    }

    fun getUser() = viewModelScope.launch {
        pickUserEntity.value = getOneUser(pickUserId.value)
    }

    init{
        getUsersForList()
    }
}