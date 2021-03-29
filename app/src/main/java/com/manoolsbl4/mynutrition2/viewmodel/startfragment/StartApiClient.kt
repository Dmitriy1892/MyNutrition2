package com.manoolsbl4.mynutrition2.viewmodel.startfragment

import com.google.gson.GsonBuilder
import com.manoolsbl4.mynutrition2.model.Hints
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class StartApiClient {



    private lateinit var service: StartFragmentApiService
    fun getApiService(): StartFragmentApiService {

        //Log REST queries to logcat
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

        //Json deserializer
        val gsonBuilder = GsonBuilder()
        gsonBuilder.registerTypeAdapter(Hints::class.java, HintsDeserializer())
        val gson = gsonBuilder.create()

        //Retrofit
        val retrofit = Retrofit.Builder().baseUrl("https://api.edamam.com").addConverterFactory(
            GsonConverterFactory.create(gson)).client(client).build()
        service = retrofit.create(StartFragmentApiService::class.java)

        return service
    }
}