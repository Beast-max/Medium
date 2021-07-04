package com.example.apii.services

import com.example.apii.model.entities.Article
import com.example.apii.model.requests.CreateArticleRequest
import com.example.apii.model.requests.UpdateArticle
import com.example.apii.model.requests.UserUpdateRequest
import com.example.apii.model.respones.ArticleResponse
import com.example.apii.model.respones.ArticlesResponse
import com.example.apii.model.respones.ProfileResponse
import com.example.apii.model.respones.UserResponse
import retrofit2.Response
import retrofit2.http.*

interface ConduitAuthAPI {
    @GET("user")
    suspend fun currentUser():Response<UserResponse>

    @GET("profiles/{username}")
    suspend fun getProfile(@Path("username") username:String):Response<ProfileResponse>

    @PUT("user")
    suspend fun updateCurrentUser(
        @Body userUpdateRequest: UserUpdateRequest
    ): Response<UserResponse>
    @POST("profile/{username}/follow")
    suspend fun followUser(@Path("username") username: String):Response<ProfileResponse>

    @DELETE ("profile/{username}/follow")
    suspend fun unFollowUser(@Path("username") username: String):Response<ProfileResponse>

    @PUT("articles/{slug}")
    suspend fun updateArticles(@Body updateArticle: UpdateArticle):Response<Article>

    @DELETE("articles/{slug}")
    suspend fun deleteArticle(@Path("slug") username: String)

    @GET("articles/feed")
    suspend fun feedArticles():Response<ArticlesResponse>

    @POST("articles/{slug}/favorite")
    suspend fun favoriteArticles(@Path("slug") slug:String):Response<ArticleResponse>
    @DELETE("articles/{slug}/favorite")
    suspend fun unfavoriteArticle(
        @Path("slug") slug: String
    ): Response<ArticleResponse>
    @POST("articles")
    suspend fun uploadarticles(@Body createArticleRequests: CreateArticleRequest):Response<ArticleResponse>




}