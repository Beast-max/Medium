package com.example.conduit.setting

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.conduit.Auth.AuthViewModel
import com.example.conduit.data.UserRepo
import com.example.conduit.databinding.FragmentSettingBinding

class SettingFragment: Fragment() {
    lateinit var binding : FragmentSettingBinding
     val authViewModel by activityViewModels<AuthViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
         binding = FragmentSettingBinding.inflate(inflater,container,false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        authViewModel._user.observe({lifecycle}){
            binding?.apply {
                bioEditText.setText(it?.bio?:"")
                emailEditText.setText(it?.email?:"")
                usernameEditText.setText(it?.username?:"")
                imageEditText.setText(it?.image?:"")
            }
        }
        binding?.apply {
            submitButton.setOnClickListener {
               authViewModel.update (
                   bio = bioEditText.text.toString(),
                username = usernameEditText.text.toString().takeIf { it.isNotBlank() },
                image = imageEditText.text.toString(),
                email = emailEditText.text.toString().takeIf { it.isNotBlank() },
                password = passwordEditText.text.toString().takeIf { it.isNotBlank() },
               )
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}