package com.manoolsbl4.mynutrition2.model

import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json

data class Nutrients(
    //"ENERC_KCAL" to null, "PROCNT" to null, "FAT" to null, "CHOCDF" to null, "FIBTG" to null

    @SerializedName("ENERC_KCAL")
    var enerc_kcal: Double?,

    @SerializedName("PROCNT")
    var procnt: Double?,

    @SerializedName("FAT")
    var fat: Double?,

    @SerializedName("CHOCDF")
    var chocdf: Double?,

    @SerializedName("FIBTG")
    var fibtg: Double?
)