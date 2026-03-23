package com.example.marchkotlin.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.supervisorScope
import okhttp3.Dispatcher

class CounterViewModel : ViewModel() {

    private val _counter = MutableLiveData<Int>()
    val counter: LiveData<Int> = _counter

    init {
        _counter.value = 0
        viewModelScope.launch(Dispatchers.IO) {
        supervisorScope {

        }
            val data = async { add() }
            data.await()
        }
    }

    fun increment() {
        _counter.value = (_counter.value ?: 0) + 1


    }

    suspend fun add(){
        delay(1000)
    }

}