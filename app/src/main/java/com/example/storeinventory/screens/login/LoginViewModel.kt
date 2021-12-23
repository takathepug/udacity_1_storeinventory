package com.example.storeinventory.screens.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * A [ViewModel] containing log in logic
 */
class LoginViewModel : ViewModel() {

    val email: MutableLiveData<String> = MutableLiveData(null)

    val password: MutableLiveData<String> = MutableLiveData(null)


    private val _eventLogin = MutableLiveData<Boolean>()
    val eventLogin: LiveData<Boolean>
        get() = _eventLogin

    init {
        _eventLogin.value = false
    }

    // In a real app, do something with credentials
    fun onLogin() {
        _eventLogin.value = true
    }
}
