package ru.random_user.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.random_user.data.room.entity.UserDB

@Database(
    entities = [UserDB::class],
    version = 1
)

abstract class DataBase : RoomDatabase() {
    abstract val dao: Dao

    companion object {
        const val DB_NAME = "random_user_app_db"
    }
}