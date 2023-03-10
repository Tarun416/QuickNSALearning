package com.example.quickprojectlearning.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.quickprojectlearning.data.database.dao.PicturesDao
import com.example.quickprojectlearning.data.database.model.PicturesEntity

@Database(version = 1, entities = [PicturesEntity::class])
abstract class PictureDatabase : RoomDatabase() {
    abstract fun pictureDao(): PicturesDao
}