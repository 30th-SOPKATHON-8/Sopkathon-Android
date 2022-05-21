package org.sopt.sopkathon_8_android.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class WriteViewModel : ViewModel() {
    val isXibal = MutableLiveData<Boolean>()
    val title = MutableLiveData<String>()
    val price = MutableLiveData<String>()
    val content = MutableLiveData<String>()

    fun setXibalGood() {
        isXibal.value = false
    }

    fun setXibalBad() {
        isXibal.value = true
    }
}