package ru.random_user.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.random_user.data.repository.UserRepositoryImpl
import ru.random_user.data.retrofit.Api
import ru.random_user.data.room.InitializeDB
import ru.random_user.data.room.DataBase
import ru.random_user.domain.repository.UserRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun provideDataBase(app: Application): DataBase {
        return Room.databaseBuilder(
            app,
            DataBase::class.java,
            DataBase.DB_NAME
        ).addCallback(InitializeDB()).build()
    }

    @Provides
    @Singleton
    fun provideDao(db: DataBase) = db.dao

    @Provides
    @Singleton
    fun provideUserRepository(db: DataBase, api: Api) : UserRepository {
        return UserRepositoryImpl(db.dao, api)
    }

}