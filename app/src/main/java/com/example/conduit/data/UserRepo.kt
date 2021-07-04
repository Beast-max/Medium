package com.example.conduit.data

import com.example.apii.ConduitClaint
import com.example.apii.model.entities.*
import com.example.apii.model.requests.LoginRequest
import com.example.apii.model.requests.SignupRequest

import com.example.apii.model.requests.UserUpdateRequest
import com.example.apii.model.respones.UserResponse

object UserRepo {
    val api = ConduitClaint.Publicapi
    val authapi = ConduitClaint.authapi

    suspend fun login(email:String,password:String): User? {
      val response = api.loginUser(LoginRequest(LoginData(email,password)))
        ConduitClaint.authToken = response.body()?.user?.token
        return response.body()?.user
    }
    suspend fun getUserProfile(){
        val response = authapi.currentUser().body()
    }
    suspend fun signup(email: String,password: String,username:String):User? {
        val response = api.registeruser(SignupRequest(Signupdata(email,password,username)))
        ConduitClaint.authToken = response.body()?.user?.token
        return response.body()?.user
    }

    suspend fun updateUser(
        bio: String?,
        username: String?,
        image: String?,
        email: String?,
        password: String?
    ): User? {
        val response = authapi.updateCurrentUser(UserUpdateRequest(UserUpdatedata(
            bio, email, image, username, password
        )))

        return response.body()?.user
    }
    suspend fun getcurrentuser(token:String): User? {
        ConduitClaint.authToken = token
       return authapi.currentUser().body()?.user
    }
}