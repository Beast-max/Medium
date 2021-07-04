package com.example.apii.model.respones


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Tags(
    @Json(name = "tags")
    val tags: List<String>
)