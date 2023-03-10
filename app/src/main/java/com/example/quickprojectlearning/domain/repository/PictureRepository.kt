package com.example.quickprojectlearning.domain.repository

import com.example.quickprojectlearning.domain.model.PictureDomain
import com.example.quickprojectlearning.domain.model.PictureRequest

interface PictureRepository {

    fun getPictures( pictureRequest: PictureRequest) : List<PictureDomain>
}