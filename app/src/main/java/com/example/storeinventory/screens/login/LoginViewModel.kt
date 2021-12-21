package com.example.storeinventory.screens.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * A [ViewModel] containing log in logic
 */
class LoginViewModel : ViewModel() {
    // The current word
    private val _email = MutableLiveData<String>()
    val email: LiveData<String>
        get() = _email
}