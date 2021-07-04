package com.example.conduit.data

import com.example.apii.ConduitClaint
import com.example.apii.model.entities.Article
import com.example.apii.model.entities.NewArticles
import com.example.apii.model.requests.CreateArticleRequest


object ArticlesRepo {
    val api = ConduitClaint.Publicapi
    val authapi = ConduitClaint.authapi

    suspend fun getArticles() = api.getArticles()

    suspend fun getMyfeed() = authapi.feedArticles()

    suspend fun createArticles(title:String,discription:String,body:String):Article?{
        val response = authapi.uploadarticles(CreateArticleRequest(NewArticles(title,discription,body)))
        return response.body()?.
    }




}