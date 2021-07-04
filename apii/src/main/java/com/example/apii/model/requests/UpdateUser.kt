package com.example.apii.model.requests


import com.example.apii.model.entities.UserUpdatedata
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)

data class UserUpdateRequest(
    @Json(name = "user")
    val user: UserUpdatedata
)