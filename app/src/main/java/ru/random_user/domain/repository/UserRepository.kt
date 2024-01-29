package ru.random_user.domain.repository

import ru.random_user.domain.entity.User

interface UserRepository {
    suspend fun getAllUsers() : List<User>
    suspend fun getOneUser(id: String) : User
    suspend fun getUserFromApi() : Result<String>
    suspend fun deleteUsers()
}