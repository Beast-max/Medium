package com.example.conduit.Auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apii.model.entities.User
import com.example.conduit.data.UserRepo
import kotlinx.coroutines.launch

class AuthViewModel:ViewModel() {
    private val user = MutableLiveData<User?>()
    val _user : MutableLiveData<User?> = user
     fun login(email:String, password:String) =viewModelScope.launch {
        UserRepo.login(email, password).let { user.postValue(it) }
    }
    fun signup(email: String,password: String,username:String) = viewModelScope.launch {
        UserRepo.signup(email,password,username).let { user.postValue(it) }
    }
    fun update(
        bio: String?,
        username: String?,
        image: String?,
        email: String?,
        password: String?
    ) = viewModelScope.launch {
        UserRepo.updateUser(bio, username, image, email, password)?.let {
            user.postValue(it)
        }
    }
    fun logout()
    {
        user.postValue(null)
    }
    fun currentuser(token:String) = viewModelScope.launch {
        UserRepo.getcurrentuser(token)?.let {
            user.postValue(it)
        }
    }
}