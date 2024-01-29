package ru.random_user.data.repository

import ru.random_user.data.retrofit.Api
import ru.random_user.data.room.Dao
import ru.random_user.domain.entity.User
import ru.random_user.domain.repository.UserRepository
import ru.random_user.toUser
import ru.random_user.toUserDB
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val dao: Dao,
    private val api: Api
) : UserRepository {
    override suspend fun getAllUsers(): List<User> {
        val listDB = dao.getUsers()
        val list = arrayListOf<User>()
        listDB.forEach{
            list.add(it.toUser())
        }
        return list
    }

    override suspend fun getOneUser(id: String): User {
        return dao.getUser(id).toUser()
    }

    override suspend fun getUserFromApi() : Result<String> {
        return try {
            val resultApi = api.getUser()
            val resultDB = resultApi.results.map {
                it.toUserDB()
            }.first()
            dao.insertUser(resultDB)
            Result.success("")
        } catch (e: Exception){
            Result.failure(e)
        }
    }

    override suspend fun deleteUsers() {
        dao.deleteUsers()
    }
}