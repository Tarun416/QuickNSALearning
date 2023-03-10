package com.example.quickprojectlearning.data.pictures.model

import com.google.gson.annotations.SerializedName

data class PictureData(
    @SerializedName("copyright")
    val copyright: String? = null,
    @SerializedName("date")
    val date: String? = null,
    @SerializedName("explanation")
    val explanation: String? = null,
    @SerializedName("hdurl")
    val hdurl: String? = null,
    @SerializedName("media_type")
    val mediaType: String? = null,
    @SerializedName("service_version")
    val serviceVersion: String? = null,
    @SerializedName("title")
    val title: String? = null,
    @SerializedName("url")
    val url: String? = null
)