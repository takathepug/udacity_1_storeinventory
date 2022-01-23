package com.example.storeinventory.screens.welcome

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.storeinventory.EventObserver
import com.example.storeinventory.R
import com.example.storeinventory.databinding.FragmentWelcomeBinding

/**
 * A [Fragment] containing the welcome screen
 */
class WelcomeFragment : Fragment() {
    private val TAG: String = javaClass.simpleName

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

        // Navigation
        setupNavigateToInstruction()

        return binding.root
    }

    private fun setupNavigateToInstruction() {
        viewModel.eventNext.observe(viewLifecycleOwner, EventObserver {
            findNavController().navigate(
                WelcomeFragmentDirections.actionWelcomeDestinationToInstructionDestination())
        })
    }

}