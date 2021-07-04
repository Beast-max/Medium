package com.example.conduit.Auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.conduit.R
import com.example.conduit.databinding.FragmentAuthBinding
import com.google.android.material.tabs.TabLayout


class Authfragement : Fragment() {
    private var _binding:FragmentAuthBinding?=null
    private var navController:NavController?=null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAuthBinding.inflate(inflater,container,false)

        return _binding!!.root
        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.let {  navController =  Navigation.findNavController(it,R.id._auth_fragment) }
        _binding?.AuthTab?.setOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                when(tab?.position){
                    0->{
                        navController?.navigate(R.id.gotosignupfragment)
                    }
                    1->{
                        navController?.navigate(R.id.gotologinfragment)
                    }
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                TODO("Not yet implemented")
            }

        })
    }
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    }


