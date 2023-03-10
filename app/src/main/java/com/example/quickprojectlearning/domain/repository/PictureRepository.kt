package com.example.quickprojectlearning.domain.repository

import com.example.quickprojectlearning.domain.model.PictureDomain
import com.example.quickprojectlearning.domain.model.PictureRequest

interface PictureRepository {

   suspend fun getPictures( pictureRequest: PictureRequest) : List<PictureDomain>
}