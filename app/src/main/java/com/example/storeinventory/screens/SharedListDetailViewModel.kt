package com.example.storeinventory.screens

import android.util.Log
import android.content.res.Resources
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.storeinventory.Event
import com.example.storeinventory.R
import com.example.storeinventory.model.Fruit

class SharedListDetailViewModel : ViewModel() {
    private val TAG: String = javaClass.simpleName

    // List screen events
    private val _eventAddFruit = MutableLiveData<Event<Unit>>()
    val eventAddFruit: LiveData<Event<Unit>> = _eventAddFruit

    // Detail screen events
    private val _eventSaveFruit = MutableLiveData<Event<Unit>>()
    val eventSaveFruit: LiveData<Event<Unit>> = _eventSaveFruit

    private val _eventCancelFruit = MutableLiveData<Event<Unit>>()
    val eventCancelFruit: LiveData<Event<Unit>> = _eventCancelFruit

    // data
    private var _fruitList = MutableLiveData<MutableList<Fruit>>(mutableListOf())
    val fruitList: LiveData<MutableList<Fruit>>
        get() = _fruitList

    // new fruit from details screen
    private var _fruit = MutableLiveData(Fruit())
    val fruit: LiveData<Fruit>
        get() = _fruit

    // Listeners
    fun onAddFruit() {
        Log.d(TAG, "Resetting new fruit data")
        clearFruit()

        _eventAddFruit.value = Event(Unit)
    }

    fun onSave() {
        Log.d(TAG, "Save fruit clicked")

        _eventSaveFruit.value = Event(Unit)
    }

    fun onCancel() {
        Log.d(TAG, "Cancel fruit clicked")

        _eventCancelFruit.value = Event(Unit)
    }

    // utils
    fun clearFruit() {
        _fruit.value?.let {
            it.company = ""
            it.description = ""
            it.kilos = ""
            it.name = ""
        }
    }

    fun saveNewFruit() {
        Log.d(TAG, "Adding new fruit to list: ${_fruit.value}")

        val currentList = _fruitList.value
        currentList!!.add(_fruit.value!!.copy())

        _fruitList.value = currentList!!

    }

}