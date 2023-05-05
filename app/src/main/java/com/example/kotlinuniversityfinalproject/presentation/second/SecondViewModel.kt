package com.example.kotlinuniversityfinalproject.presentation.second

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlinuniversityfinalproject.domain.UseCaseCoffee
import kotlinx.coroutines.launch

class SecondViewModel : ViewModel() {
    private val coffeeUseCase = UseCaseCoffee
    val myCoffeeFromApi = MutableLiveData<String>()
    val isLoading = MutableLiveData<Boolean>()

    fun getCoffee() {
        viewModelScope.launch {

            isLoading.postValue(true)
            myCoffeeFromApi.postValue(coffeeUseCase.getCoffee())
            isLoading.postValue(false)

        }
    }

}