package com.example.storeinventory.screens.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider

import com.example.storeinventory.R
import com.example.storeinventory.databinding.FragmentLoginBinding

/**
 * A [Fragment] subclass containing the Login screen.
 */
class LoginFragment : Fragment() {
    private lateinit var viewModel: LoginViewModel
    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_login,
            container,
            false
        )

        // Get the viewmodel
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

        // Allow layout access to VieWModel
        binding.loginViewModel = viewModel

        // Binding can observe LiveData updates
        binding.lifecycleOwner = this

        return binding.root
    }

}