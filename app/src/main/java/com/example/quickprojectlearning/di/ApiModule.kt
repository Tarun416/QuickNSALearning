package com.example.quickprojectlearning.di

import com.example.quickprojectlearning.data.pictures.api.PictureApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Provides
    fun providePictureApi(retrofit: Retrofit) = retrofit.create(PictureApi::class.java)
}