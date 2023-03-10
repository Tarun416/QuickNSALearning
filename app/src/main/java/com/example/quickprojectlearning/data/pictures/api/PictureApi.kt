package com.example.quickprojectlearning.data.pictures.api

import com.example.quickprojectlearning.BuildConfig
import com.example.quickprojectlearning.data.pictures.model.PictureData
import retrofit2.http.GET
import retrofit2.http.Query

interface PictureApi {

    @GET("/planetary/apod/")
    suspend fun getPictures(
        @Query("api_key") api_key: String = BuildConfig.API_KEY,
        @Query("count") count: String
    ): List<PictureData>


}