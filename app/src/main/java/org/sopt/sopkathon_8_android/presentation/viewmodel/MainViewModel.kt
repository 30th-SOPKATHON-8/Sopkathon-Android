package org.sopt.sopkathon_8_android.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.sopt.sopkathon_8_android.data.ItemData
import org.sopt.sopkathon_8_android.data.ResponseTotalData
import org.sopt.sopkathon_8_android.data.ServiceCreator

class MainViewModel : ViewModel() {
    var category: String = "all"

    private var _list = MutableLiveData<List<ItemData>>()
    val list: LiveData<List<ItemData>> get() = _list

    private var _total = MutableLiveData<ResponseTotalData.Data>()
    val total: LiveData<ResponseTotalData.Data> get() = _total

    fun getList(category: String) {
        viewModelScope.launch {
            kotlin.runCatching {
                ServiceCreator.service.getList(category)
            }.onSuccess {
                _list.value = it.data
            }.onFailure {
                Log.e("시발", "왜안돼")
                Log.e("시발 리스트", it.toString())
            }
        }
    }

    fun getTotalInfo() {
        viewModelScope.launch {
            kotlin.runCatching {
                ServiceCreator.service.getTotal()
            }.onSuccess {
                _total.value = it.data
            }.onFailure {
                Log.e("시발", "토탈제발")
                Log.e("시발 토탈", it.toString())
            }
        }
    }
}