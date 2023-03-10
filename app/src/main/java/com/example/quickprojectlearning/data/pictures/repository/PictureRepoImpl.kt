package com.example.quickprojectlearning.data.pictures.repository

import com.example.quickprojectlearning.data.pictures.factory.PictureFactory
import com.example.quickprojectlearning.domain.model.PictureDomain
import com.example.quickprojectlearning.domain.model.PictureRequest
import com.example.quickprojectlearning.domain.repository.PictureRepository
import com.example.quickprojectlearning.util.Source
import javax.inject.Inject

class PictureRepoImpl @Inject constructor(private val factory: PictureFactory) : PictureRepository {

    override suspend fun getPictures(pictureRequest: PictureRequest): List<PictureDomain> {
        return factory.create(Source.LOCAL).getPictures(pictureRequest)
    }
}