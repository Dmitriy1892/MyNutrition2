package com.manoolsbl4.mynutrition2.viewmodel.startfragment

import com.manoolsbl4.mynutrition2.model.Hints
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface StartFragmentApiService {

    @GET("/api/food-database/v2/parser")
    suspend fun searchFood(
        @Query("ingr")
        food: String,

        @Query("app_id")
        appId: String = "489f7f8d",

        @Query("app_key")
        appKey: String = "7167ea5c65592edf16445f0543cf9d56"): Response<Hints>

}