package com.manoolsbl4.mynutrition2.viewmodel.favoritesfragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.manoolsbl4.mynutrition2.room.FoodDao
import com.manoolsbl4.mynutrition2.room.FoodDatabase
import com.manoolsbl4.mynutrition2.room.FoodModel

class FavoritesViewModel(val dbDao: FoodDao): ViewModel() {
    private val _rvData = MutableLiveData<List<FoodModel>>()
    val rvData: LiveData<List<FoodModel>>
        get() = _rvData

    fun addDb(db: FoodDatabase) {

    }
}