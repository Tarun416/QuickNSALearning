package com.example.quickprojectlearning.data.pictures.mapper

import com.example.quickprojectlearning.data.database.model.PicturesEntity
import com.example.quickprojectlearning.domain.model.PictureDomain

object PictureDomainMapper {

    fun List<PictureDomain>.toPictureEntity(): List<PicturesEntity> {
        var entityList = mutableListOf<PicturesEntity>()

        for (item in this) {
            entityList.add(
                PicturesEntity(
                    explanation = item.explanation!!,
                    date = System.currentTimeMillis().toString(),
                    hdurl = item.hdurl!!,
                    title = item.title!!,
                    url = item.url!!
                )
            )
        }
        return entityList
    }
}