package com.example.conduit.ui.feeds

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.conduit.R
import com.example.conduit.databinding.FragmentFeedBinding

class Globalfeed: Fragment() {
    private var fragmentFeedBinding:FragmentFeedBinding?=null
    private lateinit var viewModel:FeedViewModel
    private lateinit var feedAdapter: FeedAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        feedAdapter = FeedAdapter{openArticle(it)}
        viewModel = ViewModelProvider(this).get(FeedViewModel::class.java)
       fragmentFeedBinding = FragmentFeedBinding.inflate(inflater,container,false)
       fragmentFeedBinding?.recyclerView?.layoutManager = LinearLayoutManager(context)

        return fragmentFeedBinding?.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentFeedBinding?.recyclerView?.adapter = feedAdapter
        viewModel.feed.observe({lifecycle}){
            feedAdapter.submitList(it)
        }
        viewModel.fatchGlobalfeed()
    }
    fun openArticle(articleid:String){
        findNavController().navigate(R.id.action_Feed_to_nav_article,

        bundleOf(
          resources.getString(R.string.arg_article_id) to articleid
        )
        )
        }


    override fun onDestroy() {
        super.onDestroy()
        fragmentFeedBinding = null
    }
}