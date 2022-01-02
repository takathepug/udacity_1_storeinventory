package com.example.storeinventory.screens

import android.util.Log
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

    private var _fruit = MutableLiveData<Fruit>()
    val fruit: LiveData<Fruit>
        get() = _fruit

    fun onAddFruit() {
        Log.d(TAG, "Add fruit clicked")
        _fruit.value = FruitFactory.next()

        _eventAddFruit.value = Event(Unit)
    }

    fun onSave() {
        Log.d(TAG, "Save fruit clicked")
    }

    fun onCancel() {
        Log.d(TAG, "Cancel fruit clicked")
    }

    // Factory of fruits to randomly show them in New Fruit Detail screen every time the user
    // clicks on Add new fruit
    object FruitFactory {
        private val values: List<Fruit> = listOf(
            Fruit(R.string.peach.toString(), image=R.drawable.ic_peach_icon),
            Fruit(R.string.pear.toString(), image=R.drawable.ic_pear_icon),
            Fruit(R.string.strawberry.toString(), image=R.drawable.ic_strawberry_icon)
        )

        fun next(): Fruit {
            return values.random()
        }
    }
}