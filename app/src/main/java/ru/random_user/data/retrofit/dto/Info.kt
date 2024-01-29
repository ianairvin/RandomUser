package ru.random_user.data.retrofit.dto

data class Info(
    val page: Int,
    val results: Int,
    val seed: String,
    val version: String
)