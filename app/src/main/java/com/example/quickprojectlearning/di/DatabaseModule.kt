package com.example.quickprojectlearning.di

import android.content.Context
import androidx.room.Room
import com.example.quickprojectlearning.data.database.PictureDatabase
import com.example.quickprojectlearning.data.database.dao.PicturesDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    private const val database_name = "nasa_db"

    @Provides
    fun provideDatabase(@ApplicationContext context: Context): PictureDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            PictureDatabase::class.java,
            database_name
        ).build()
    }

    @Provides
    fun provideDao(database: PictureDatabase): PicturesDao {
        return database.pictureDao()
    }
}