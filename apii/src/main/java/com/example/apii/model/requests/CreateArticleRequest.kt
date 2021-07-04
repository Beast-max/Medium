package com.example.apii.model.requests


import com.example.apii.model.entities.NewArticles
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CreateArticleRequest(
    @Json(name = "article")
    val article: NewArticles
)