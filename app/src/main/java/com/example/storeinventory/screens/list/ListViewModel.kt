package com.example.storeinventory.screens.list

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.storeinventory.Event
import com.example.storeinventory.model.Fruit

class ListViewModel : ViewModel() {
    private val TAG: String = javaClass.simpleName

    private val _eventAddFruit = MutableLiveData<Event<Unit>>()
    val eventAddFruit: LiveData<Event<Unit>> = _eventAddFruit

    private var _fruitList = MutableLiveData<MutableList<Fruit>>(mutableListOf())
    val fruitList: LiveData<MutableList<Fruit>>
        get() = _fruitList

    fun onAddFruit() {
        Log.d(TAG, "Add fruit pressed")
        _eventAddFruit.value = Event(Unit)
    }
}