package com.manoolsbl4.mynutrition2.model

import com.google.gson.annotations.SerializedName

data class Hints(

    @SerializedName( "text")
    var name: String?,


    @SerializedName("parsed")
    var parsed: List<Food>?,

    @SerializedName("hints")
    var hints: List<Food>?
)