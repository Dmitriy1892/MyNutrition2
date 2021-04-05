package com.manoolsbl4.mynutrition2.viewmodel.detailfragment

import com.google.gson.GsonBuilder
import com.manoolsbl4.mynutrition2.model.Hints
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DetailsApiClient {
    private lateinit var service: DetaisFragmentApiService

    fun getApiService(): DetaisFragmentApiService {
        //Log REST queries to logcat
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

        //Json deserializer
        val gsonBuilder = GsonBuilder()
        gsonBuilder.registerTypeAdapter(Hints::class.java, DetailsHintsDeserializer())
        val gson = gsonBuilder.create()

        //Retrofit
        val retrofit = Retrofit.Builder().baseUrl("https://api.edamam.com").addConverterFactory(
            GsonConverterFactory.create(gson)).client(client).build()
        service = retrofit.create(DetaisFragmentApiService::class.java)

        return service
    }

}