package com.example.storeinventory.screens.login

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * A [ViewModel] containing log in logic
 */
class LoginViewModel : ViewModel() {
    private val TAG: String = javaClass.simpleName

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
        Log.d(TAG, "User ${email.value} attempting login")
        _eventLogin.value = true
    }

    fun onLoginCompleted() {
        Log.d(TAG, "Login for user ${email.value} completed")
        _eventLogin.value = false
    }
}
