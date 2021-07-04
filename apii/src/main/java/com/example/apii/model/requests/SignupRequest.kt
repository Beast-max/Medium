package com.example.apii.model.requests


import com.example.apii.model.entities.Signupdata
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SignupRequest(
    @Json(name = "user")
    val user: Signupdata
)