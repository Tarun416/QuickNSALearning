package com.example.quickprojectlearning.data.pictures.source.local

import com.example.quickprojectlearning.data.database.dao.PicturesDao
import com.example.quickprojectlearning.data.pictures.mapper.PictureDomainMapper.toPictureEntity
import com.example.quickprojectlearning.data.pictures.mapper.PictureEntityMapper.toPictureDomain
import com.example.quickprojectlearning.data.pictures.source.PictureEntityData
import com.example.quickprojectlearning.domain.model.PictureDomain
import com.example.quickprojectlearning.domain.model.PictureRequest
import javax.inject.Inject

class LocalEntity @Inject constructor(private val dao: PicturesDao) : PictureEntityData {
    override suspend fun getPictures(pictureRequest: PictureRequest): List<PictureDomain> {
        return dao.getAllData().toPictureDomain()
    }

    override suspend fun addPictures(pictureList: List<PictureDomain>) {
        dao.insertAll(pictureList.toPictureEntity())
    }

}