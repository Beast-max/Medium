package com.example.apii.model.respones


import com.example.apii.model.entities.Comment
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CommentsResponse(
    @Json(name = "comment")
    val comment: List<Comment>
)