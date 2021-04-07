package com.manoolsbl4.mynutrition2.viewmodel.favoritesfragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.manoolsbl4.mynutrition2.room.FoodDao

class FavoritesViewModelFactory(val dao: FoodDao): ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return if (modelClass == FavoritesViewModel::class.java) {
            FavoritesViewModel(dao) as T
        } else super.create(modelClass)
    }
}