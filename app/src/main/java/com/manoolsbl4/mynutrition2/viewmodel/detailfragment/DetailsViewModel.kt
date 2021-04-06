package com.manoolsbl4.mynutrition2.viewmodel.detailfragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.manoolsbl4.mynutrition2.model.Food
import com.manoolsbl4.mynutrition2.model.Hints
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailsViewModel : ViewModel() {
    private lateinit var foodId: String

    private var _food: MutableLiveData<Food> = MutableLiveData()

    val food:LiveData<Food>
        get() = _food

    fun loadFood(foodId: String) {
        viewModelScope.launch {
            val service = DetailsApiClient().getApiService()
            service.searchFoodWithId(foodId = foodId, appId = "489f7f8d", appKey = "7167ea5c65592edf16445f0543cf9d56")
                    .enqueue(object: Callback<Hints> {
                        override fun onResponse(call: Call<Hints>, response: Response<Hints>) {
                            val res = response.body()
                            if (res?.hints != null) {
                                _food.value = res?.hints?.get(0)
                            }
                        }

                        override fun onFailure(call: Call<Hints>, t: Throwable) {
                            println("fail")
                        }
                    })
        }
    }
}