package com.manoolsbl4.mynutrition2.viewmodel.detailfragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.manoolsbl4.mynutrition2.model.Food
import kotlinx.coroutines.launch

class DetailsViewModel : ViewModel() {
    private lateinit var foodId: String

    private lateinit var _food: MutableLiveData<Food>

    val food:LiveData<Food>
        get() = _food

    fun loadFood(foodId: String) {
        viewModelScope.launch {
            val service = DetailsApiClient().getApiService()
            val data = service.searchFoodWithId(foodId).body()
            if (data?.hints != null) {
                _food = MutableLiveData(data?.hints!!.get(0))
            }
        }
    }
}