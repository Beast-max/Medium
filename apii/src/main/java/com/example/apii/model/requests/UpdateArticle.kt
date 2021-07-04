package com.example.apii.model.requests


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UpdateArticle(
    @Json(name = "article")
    val article: Article
)