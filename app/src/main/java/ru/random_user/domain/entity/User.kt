package ru.random_user.domain.entity

data class User(
    val id: String,
    val gender: String,
    val nat: String,
    val name: String,
    val email : String,
    val login: String,
    val password: String,
    val phone: String,
    val picture: String,
    val age: String,
    val address: String,
    val street: String,
    val coordinates: String
)