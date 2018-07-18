package com.padcmyanmar.mmhealthcare.data.model

import android.content.Context
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.padcmyanmar.mmhealthcare.networks.HealthAPI
import com.padcmyanmar.mmhealthcare.utils.AppConstance
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

abstract class BaseModel (context: Context){

    protected var mAPI:HealthAPI?=null
    init {
        val httpClient = OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .build()
        val retrofit = Retrofit.Builder()
                .baseUrl(AppConstance.base_url)
                .client(httpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
        mAPI = retrofit.create(HealthAPI::class.java)

    }

}