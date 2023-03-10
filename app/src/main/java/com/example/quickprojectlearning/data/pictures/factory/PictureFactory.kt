package com.example.quickprojectlearning.data.pictures.factory

import com.example.quickprojectlearning.data.pictures.source.PictureEntityData
import com.example.quickprojectlearning.data.pictures.source.local.LocalEntity
import com.example.quickprojectlearning.data.pictures.source.network.NetworkEntity
import com.example.quickprojectlearning.util.Source
import javax.inject.Inject

class PictureFactory @Inject constructor(
    private val localEntity: LocalEntity,
    private val networkEntity: NetworkEntity
) {

    fun create(source: Source): PictureEntityData {
        return when (source) {
            Source.LOCAL -> localEntity
            else -> networkEntity
        }
    }


}