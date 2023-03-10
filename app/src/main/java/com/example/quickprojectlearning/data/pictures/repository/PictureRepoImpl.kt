package com.example.quickprojectlearning.data.pictures.repository

import com.example.quickprojectlearning.domain.model.PictureDomain
import com.example.quickprojectlearning.domain.model.PictureRequest
import com.example.quickprojectlearning.domain.repository.PictureRepository

class PictureRepoImpl : PictureRepository {

    override fun getPictures(pictureRequest: PictureRequest): List<PictureDomain> {
            return listOf()
    }
}