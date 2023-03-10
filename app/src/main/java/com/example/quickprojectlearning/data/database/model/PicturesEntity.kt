package com.example.quickprojectlearning.data.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("nasa_table")
data class PicturesEntity(
    val copyright: String? = null,
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val explanation: String,
    val hdurl: String,
    val media_type: String? = null,
    val service_version: String? = null,
    val title: String,
    val url: String
)