package com.example.apii.services

import com.example.apii.model.requests.LoginRequest
import com.example.apii.model.requests.SignupRequest
import com.example.apii.model.respones.ArticleResponse
import com.example.apii.model.respones.ArticlesResponse
import com.example.apii.model.respones.UserResponse
import retrofit2.Response
import retrofit2.http.*

interface ConduitApi {
    @GET("articles/{slug}")
    suspend fun getArticle(@Path("slug")slug:String):Response<ArticleResponse>
    @GET("articles")
  suspend  fun getArticles(@Query("author") author: String? = null,
                           @Query("favourited") favourited: String? = null,
                           @Query("tag") tag: String? = null): Response<ArticlesResponse>
  @POST("users")
  suspend fun registeruser(@Body userCrads: SignupRequest):Response<UserResponse>

    @POST("users/login")
    suspend fun loginUser(
        @Body userCreds: LoginRequest
    ): Response<UserResponse>




}