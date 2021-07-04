package com.example.conduit.CreateArticles

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import com.example.conduit.R
import com.example.conduit.databinding.ActivityCreateArticlesArtivityBinding

class CreateArticlesArtivity : AppCompatActivity() {
    lateinit var createArticlesViewModel:CreateArticlesViewModel
    private lateinit var createArticlesArtivityBinding: ActivityCreateArticlesArtivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        createArticlesViewModel = CreateArticlesViewModel()
        createArticlesArtivityBinding = ActivityCreateArticlesArtivityBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_articles_artivity)
        createArticlesArtivityBinding.submitButton.setOnClickListener {
            articlesupload()
        }

    }

   fun articlesupload()
   {
       createArticlesViewModel.newaritclal(
           title = createArticlesArtivityBinding.title.text.toString(),
           discription = createArticlesArtivityBinding.descrption.text.toString(),
           body = createArticlesArtivityBinding.body.text.toString()
               )
           }
       }
