package com.example.quickprojectlearning.di

import android.content.Context
import androidx.room.Room
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
    fun provideDatabase(@ApplicationContext context: Context): com.example.quickprojectlearning.data.database.PictureDatabase {
        return Room.databaseBuilder(
            context,
            com.example.quickprojectlearning.data.database.PictureDatabase::class.java,
            database_name
        ).build()
    }

    @Provides
    fun provideDao(database: com.example.quickprojectlearning.data.database.PictureDatabase): PicturesDao {
        return database.pictureDao()
    }
}