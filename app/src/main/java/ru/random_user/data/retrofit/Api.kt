package ru.random_user.data.retrofit

import ru.random_user.data.retrofit.dto.UserDTO
import retrofit2.http.GET

interface Api {
    @GET("api/")
    suspend fun getUser() : UserDTO
}