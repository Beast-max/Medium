package com.example.conduit.ui.feeds

import android.annotation.SuppressLint
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.apii.model.entities.Article
import com.example.conduit.R
import com.example.conduit.databinding.ListItemArticlesBinding
import com.example.conduit.extensions.loadImage
import com.example.conduit.extensions.timeStamp


class FeedAdapter(val onitemclick:(slug:String)->Unit):ListAdapter<Article,FeedAdapter.ArticleViewHolder>(
     object :DiffUtil.ItemCallback<Article>() {


    override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
      return oldItem === newItem
    }

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
       return oldItem.toString()===newItem.toString()
    }
})

{

    inner class ArticleViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        return ArticleViewHolder(parent.context.getSystemService(LayoutInflater::class.java).inflate(
            R.layout.list_item_articles,parent,false))

    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
          ListItemArticlesBinding.bind(holder.itemView).apply {
              val article = getItem(position)
              authorTextView.text = article.author.username
              titleTextView.text = article.title
              bodySnippetTextView.text = article.body
              avatarImageView.loadImage(article.author.image,true)
              dateTextView.timeStamp=article.createdAt
              bodySnippetTextView.setOnClickListener { onitemclick(article.slug) }
          }
    }
}