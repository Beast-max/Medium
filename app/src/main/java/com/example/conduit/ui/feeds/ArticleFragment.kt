package com.example.conduit.ui.feeds

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.conduit.R
import com.example.conduit.databinding.ArticleviewBinding
import com.example.conduit.extensions.loadImage

class ArticleFragment:Fragment() {
    private var binding: ArticleviewBinding?=null
    private var articleid:String?=null
    lateinit var articleViewModel: ArticleViewModel



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        articleViewModel = ViewModelProvider(this).get(ArticleViewModel::class.java)
        binding = ArticleviewBinding.inflate(inflater,container,false)
        arguments?.let {
            articleid=it.getString(resources.getString(R.string.arg_article_id))

            articleid?.let { articleViewModel.getart(it) }
        }
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        articleViewModel.feed.observe({lifecycle}){
            binding?.apply {
                titleTextView.text = it.title
                bodyTextView.text = it.body
                username.text = it.author.username
                userimage.loadImage(it.author.image,true)

            }
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}