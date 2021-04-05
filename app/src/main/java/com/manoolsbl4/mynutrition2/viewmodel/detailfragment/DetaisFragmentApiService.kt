package com.manoolsbl4.mynutrition2.viewmodel.detailfragment

import com.manoolsbl4.mynutrition2.model.Hints
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface DetaisFragmentApiService {

    @GET("/api/food-database/v2/parser")
    fun searchFoodWithId(
        @Query("ingr")
        foodId: String,

        @Query("app_id")
        appId: String = "489f7f8d",

        @Query("app_key")
        appKey: String = "7167ea5c65592edf16445f0543cf9d56"
    ): Response<Hints>
}