package com.manoolsbl4.mynutrition2.viewmodel.startfragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.manoolsbl4.mynutrition2.model.Food
import kotlinx.coroutines.launch


class StartViewModel : ViewModel() {

    private val _rvData = MutableLiveData<List<Food>>()

    val rvData: LiveData<List<Food>>
        get() = _rvData

    init {
        _rvData.value = listOf()
    }

    fun searchFood(foodName: String) {
        viewModelScope.launch {
            val service = StartApiClient().getApiService()
            val data = service.searchFood(foodName).body()
            if (data?.hints != null) {
                _rvData.value = data.hints!!
            } else {
                _rvData.value = listOf()
            }
        }
    }
}