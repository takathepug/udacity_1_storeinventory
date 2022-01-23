package com.example.storeinventory.screens.instruction

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.storeinventory.Event

class InstructionViewModel : ViewModel() {
    private val TAG: String = javaClass.simpleName

    private val _eventNext = MutableLiveData<Event<Unit>>()
    val eventNext: LiveData<Event<Unit>> = _eventNext

    fun onNext() {
        Log.d(TAG, "Next pressed")
        _eventNext.value = Event(Unit)
    }
}