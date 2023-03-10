package com.example.quickprojectlearning.data.pictures.source

import com.example.quickprojectlearning.domain.model.PictureDomain
import com.example.quickprojectlearning.domain.model.PictureRequest

interface PictureEntityData {

    suspend fun getPictures(pictureRequest: PictureRequest) : List<PictureDomain>

    suspend fun addPictures(pictureList: List<PictureDomain>)
}