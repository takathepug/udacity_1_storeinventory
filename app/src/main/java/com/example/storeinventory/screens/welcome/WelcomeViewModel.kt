package com.example.storeinventory.screens.welcome

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class WelcomeViewModel : ViewModel() {
    private val TAG: String = javaClass.simpleName

    private val _eventNext = MutableLiveData<Boolean>()
    val eventNext: LiveData<Boolean>
        get() = _eventNext

    /*init {
        _eventNext.value = false
    }*/

    fun onNext() {
        Log.d(TAG, "Next pressed")
        _eventNext.value = true
    }

    fun onNextCompleted() {
        Log.d(TAG, "Next completed")
        _eventNext.value = false
    }
}