package com.example.storeinventory.screens.welcome

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.storeinventory.R
import com.example.storeinventory.databinding.FragmentWelcomeBinding

class WelcomeFragment : Fragment() {
    private lateinit var viewModel: WelcomeViewModel
    private lateinit var binding: FragmentWelcomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_welcome,
            container,
            false
        )

        // Get the viewmodel
        viewModel = ViewModelProvider(this).get(WelcomeViewModel::class.java)

        // Allow layout access to VieWModel
        binding.welcomeViewModel = viewModel

        // Binding can observe LiveData updates
        binding.lifecycleOwner = this

        return binding.root
    }

}