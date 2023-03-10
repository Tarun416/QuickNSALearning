package com.example.quickprojectlearning.data.pictures.mapper

import com.example.quickprojectlearning.data.database.model.PicturesEntity
import com.example.quickprojectlearning.data.pictures.model.PictureData
import com.example.quickprojectlearning.domain.model.PictureDomain

object PictureDataMapper {

    fun List<PictureData>.toPictureDomain(): List<PictureDomain> {
        var domainList = mutableListOf<PictureDomain>()

        for (item in this) {
            domainList.add(PictureDomain(item.explanation, item.hdurl, item.title, item.url))
        }
        return domainList
    }
}