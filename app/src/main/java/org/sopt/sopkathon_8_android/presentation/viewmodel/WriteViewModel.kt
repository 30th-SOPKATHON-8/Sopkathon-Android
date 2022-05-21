package org.sopt.sopkathon_8_android.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.sopt.sopkathon_8_android.data.RequestPost
import org.sopt.sopkathon_8_android.data.ResponsePost
import org.sopt.sopkathon_8_android.data.ServiceCreator

class WriteViewModel : ViewModel() {
    val isXibal = MutableLiveData<Boolean>()
    val title = MutableLiveData<String>()
    val price = MutableLiveData<String>()
    val content = MutableLiveData<String>()
    val isSuccess = MutableLiveData<Boolean>()
    val response = MutableLiveData<ResponsePost.Data>()

    fun setXibalGood() {
        isXibal.value = false
    }

    fun setXibalBad() {
        isXibal.value = true
    }

    fun post() {
        viewModelScope.launch {
            kotlin.runCatching {
                ServiceCreator.service.post(
                    RequestPost(
                        isXibal = requireNotNull(isXibal.value),
                        title = requireNotNull(title.value),
                        price = requireNotNull(price.value).toInt(),
                        content = content.value ?: ""
                    )
                )
            }.onSuccess {
                isSuccess.value = true
                response.value = it.data
            }.onFailure {
                Log.e("ㅋㅋ", "ㅋㅋ")
            }
        }
    }
}