package com.example.quickprojectlearning.domain.usecases

import com.example.quickprojectlearning.domain.model.PictureDomain
import com.example.quickprojectlearning.domain.model.PictureRequest
import com.example.quickprojectlearning.domain.repository.PictureRepository
import javax.inject.Inject

class GetPictures @Inject constructor(val repository: PictureRepository) {

    suspend fun execute(pictureRequest: PictureRequest) : List<PictureDomain> {
       return repository.getPictures(pictureRequest)
    }
}