package com.example.apii.model.entities


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UpdateUserEntitie(
    @Json(name = "user")
    val user: UserUpdatedata
)