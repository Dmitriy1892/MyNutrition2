package com.manoolsbl4.mynutrition2.model

import com.google.gson.annotations.SerializedName

data class Food(

    @SerializedName("foodId")
    var foodId: String?,

    @SerializedName( "label")
    var label: String?,

    @SerializedName("nutrients")
    var nutrients: Nutrients,

    @SerializedName("image")
    var image: String?
)