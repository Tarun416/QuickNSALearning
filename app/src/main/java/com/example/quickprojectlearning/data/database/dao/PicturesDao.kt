package com.example.quickprojectlearning.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.quickprojectlearning.data.database.model.PicturesEntity


@Dao
interface PicturesDao {

    @Query("Select * from nasa_table")
    suspend fun getAllData(): List<PicturesEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(list: List<PicturesEntity>)

    @Query("Delete from nasa_table")
    fun delete()
}
