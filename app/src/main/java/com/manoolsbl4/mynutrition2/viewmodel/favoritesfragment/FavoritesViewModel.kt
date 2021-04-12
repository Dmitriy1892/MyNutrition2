package com.manoolsbl4.mynutrition2.viewmodel.favoritesfragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.manoolsbl4.mynutrition2.room.FoodDao
import com.manoolsbl4.mynutrition2.room.FoodDatabase
import com.manoolsbl4.mynutrition2.room.FoodModel
import kotlinx.coroutines.async

class FavoritesViewModel(dbDao: FoodDao): ViewModel() {
    private val _rvData = MutableLiveData<List<FoodModel>>()
    val rvData: LiveData<List<FoodModel>>
        get() = _rvData

    init {
        viewModelScope.async {
            _rvData.value = dbDao.getAllFood()
        }
    }
}