package com.example.conduit.CreateArticles

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apii.ConduitClaint
import com.example.apii.model.entities.Article
import com.example.conduit.data.ArticlesRepo
import kotlinx.coroutines.launch

class CreateArticlesViewModel:ViewModel() {


    private val art = MutableLiveData<Article>()
    val feed: MutableLiveData<Article> = art

     fun newaritclal(title:String,discription:String,body:String) = viewModelScope.launch {
      ArticlesRepo.createArticles(title,discription,body).let {
           feed.postValue(it)
       }

    }

    
}