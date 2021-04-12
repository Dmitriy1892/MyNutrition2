package com.manoolsbl4.mynutrition2.viewmodel.detailfragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.manoolsbl4.mynutrition2.room.FoodDao

class DetailsViewModelFactory(val dao: FoodDao): ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return if (modelClass == DetailsViewModel::class.java) {
            DetailsViewModel(dao) as T
        } else super.create(modelClass)
    }
}