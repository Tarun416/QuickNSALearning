package com.example.quickprojectlearning.data.pictures.source.network

import com.example.quickprojectlearning.data.pictures.api.PictureApi
import com.example.quickprojectlearning.data.pictures.mapper.PictureDataMapper.toPictureDomain
import com.example.quickprojectlearning.data.pictures.source.PictureEntityData
import com.example.quickprojectlearning.domain.model.PictureDomain
import com.example.quickprojectlearning.domain.model.PictureRequest
import javax.inject.Inject

class NetworkEntity @Inject constructor(private val api: PictureApi) : PictureEntityData {
    override suspend fun getPictures(pictureRequest: PictureRequest): List<PictureDomain> {
        return api.getPictures(count = pictureRequest.count.toString()).toPictureDomain()

    }

    override suspend fun addPictures(pictureList: List<PictureDomain>) {

    }
}