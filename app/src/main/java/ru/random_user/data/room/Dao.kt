package ru.random_user.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import ru.random_user.data.room.entity.UserDB

@Dao
interface Dao {
    @Query("SELECT * FROM user_table")
    suspend fun getUsers(): List<UserDB>

    @Query("SELECT * FROM user_table WHERE id = :id")
    suspend fun getUser(id: String): UserDB

    @Insert
    suspend fun insertUser(user: UserDB)

    @Query("DELETE FROM user_table")
    suspend fun deleteUsers()
}