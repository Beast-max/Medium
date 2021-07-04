package com.example.conduit.Auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.conduit.databinding.FrafmentLoginSignupBinding
import com.example.conduit.databinding.SignupactivityBinding

class Signupfragment :Fragment(){
    private var _binding: FrafmentLoginSignupBinding?=null
    val authViewModel: AuthViewModel by activityViewModels<AuthViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FrafmentLoginSignupBinding.inflate(inflater,container,false)
        _binding?.username?.isVisible = true
        return _binding?.root
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding?.apply { loginbuttom.setOnClickListener {
            authViewModel.signup(email.text.toString(),password.text.toString(),username.text.toString())
        }
        }
    }
}