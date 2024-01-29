package ru.random_user.data.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class UserDB(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val name: String,
    val gender: String,
    val nat: String,
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
