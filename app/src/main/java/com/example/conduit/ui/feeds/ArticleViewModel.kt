package com.example.conduit.ui.feeds

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apii.ConduitClaint
import com.example.apii.model.entities.Article
import com.example.apii.services.ConduitAuthAPI
import com.example.conduit.data.ArticlesRepo
import com.example.conduit.databinding.ArticleviewBinding
import kotlinx.coroutines.launch

class ArticleViewModel: ViewModel() {
    val api = ConduitClaint.Publicapi
    private val art = MutableLiveData<Article>()
    val feed: MutableLiveData<Article> = art


    fun getart(articleid:String) = viewModelScope.launch {
        val response = api.getArticle(articleid)

        response.body()?.article.let { art.postValue(it) }

    }

}