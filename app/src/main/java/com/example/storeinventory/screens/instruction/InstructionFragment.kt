package com.example.storeinventory.screens.instruction

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.storeinventory.EventObserver
import com.example.storeinventory.R
import com.example.storeinventory.databinding.FragmentInstructionBinding
import androidx.navigation.fragment.findNavController

/**
 * A [Fragment] containing the instructions screen
 */
class InstructionFragment : Fragment() {
    private val TAG: String = javaClass.simpleName

    private lateinit var viewModel: InstructionViewModel
    private lateinit var binding: FragmentInstructionBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_instruction,
            container,
            false
        )

        // Get the viewmodel
        viewModel = ViewModelProvider(this).get(InstructionViewModel::class.java)

        // Allow layout access to VieWModel
        binding.instructionViewModel = viewModel

        // Binding can observe LiveData updates
        binding.lifecycleOwner = this

        // Navigation
        setupNavigateToList()

        return binding.root
    }

    private fun setupNavigateToList() {
        viewModel.eventNext.observe(viewLifecycleOwner, EventObserver {
            findNavController().navigate(
                InstructionFragmentDirections.actionInstructionDestinationToListDestination())
        })
    }

}