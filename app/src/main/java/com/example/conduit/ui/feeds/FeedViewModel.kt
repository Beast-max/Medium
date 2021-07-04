package com.example.conduit.ui.feeds

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apii.ConduitClaint
import com.example.apii.model.entities.Article
import com.example.apii.services.ConduitAuthAPI
import com.example.conduit.data.ArticlesRepo
import kotlinx.coroutines.launch

class FeedViewModel :ViewModel(){

    private val _feed = MutableLiveData<List<Article>>()

    val feed: MutableLiveData<List<Article>> = _feed

    fun fatchGlobalfeed() = viewModelScope.launch {
        ArticlesRepo.getArticles().body()?.let {
            _feed.postValue(it.articles)
        }
     }
    fun myFeed() = viewModelScope.launch {
        ArticlesRepo.getMyfeed().body()?.let {
            _feed.postValue(it.articles)
        }
    }
}