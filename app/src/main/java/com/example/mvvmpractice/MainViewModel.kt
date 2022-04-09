package com.example.mvvmpractice

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

//class MainViewModel(num : Int) : ViewModel() {
class MainViewModel() : ViewModel() {

//    var count = 0
//    var count = num

    var textLiveData = MutableLiveData<String>("Original live data")

    val livedata : LiveData<String> = textLiveData

    fun increaseCount() {
//        count++
        textLiveData.value = "Data Changed"
    }

}