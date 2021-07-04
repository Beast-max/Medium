package com.example.apii

import com.example.apii.services.ConduitApi
import com.example.apii.services.ConduitAuthAPI
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

object ConduitClaint {
     var authToken:String?=null

    private val authInterceptor = Interceptor { chain ->
        var req = chain.request()
        authToken?.let {
            req = req.newBuilder()
                .header("Authorization", "Token $it")
                .build()
        }
        chain.proceed(req)
    }

    val oKHttpBuilder = OkHttpClient.Builder()
        .readTimeout(5,TimeUnit.SECONDS)
        .connectTimeout(2,TimeUnit.SECONDS )

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://conduit.productionready.io/api/")
        .client(oKHttpBuilder.build())
        .addConverterFactory(MoshiConverterFactory.create())


    val  Publicapi = retrofit
        .build()
        .create(ConduitApi::class.java)

    val  authapi = retrofit
        .client(oKHttpBuilder.addInterceptor(authInterceptor).build())
        .build()
        .create(ConduitAuthAPI::class.java)
}