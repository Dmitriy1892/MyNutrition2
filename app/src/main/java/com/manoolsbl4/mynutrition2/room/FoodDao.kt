package com.manoolsbl4.mynutrition2.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface FoodDao {
    @Insert
    suspend fun insertAll(vararg food: FoodModel)

    @Delete
    suspend fun delete(food: FoodModel)

    @Query("SELECT * FROM favorites_table")
    fun getAllFood(): List<FoodModel>
}