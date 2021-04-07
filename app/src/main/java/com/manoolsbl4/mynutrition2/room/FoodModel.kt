package com.manoolsbl4.mynutrition2.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorites_table")
data class FoodModel(
        @PrimaryKey
        var foodId: String,

        @ColumnInfo(name = "label")
        var label: String?,

        @ColumnInfo(name ="image")
        var image: String?,

        @ColumnInfo(name ="ENERC_KCAL")
        var enerc_kcal: Double?,

        @ColumnInfo(name = "PROCNT")
        var procnt: Double?,

        @ColumnInfo(name = "FAT")
        var fat: Double?,

        @ColumnInfo(name ="CHOCDF")
        var chocdf: Double?,

        @ColumnInfo(name ="FIBTG")
        var fibtg: Double?

)
