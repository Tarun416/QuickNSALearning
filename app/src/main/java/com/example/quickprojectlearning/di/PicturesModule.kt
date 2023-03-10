package com.example.quickprojectlearning.di

import com.example.quickprojectlearning.data.pictures.api.PictureApi
import com.example.quickprojectlearning.data.pictures.repository.PictureRepoImpl
import com.example.quickprojectlearning.domain.repository.PictureRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class PicturesModule {

    @Binds
    abstract fun providePictureRepo(pictureRepoImpl: PictureRepoImpl): PictureRepository
}