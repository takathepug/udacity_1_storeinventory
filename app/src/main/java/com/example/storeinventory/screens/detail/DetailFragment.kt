package com.example.storeinventory.screens.detail

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.storeinventory.EventObserver
import com.example.storeinventory.R
import com.example.storeinventory.databinding.FragmentDetailBinding
import com.example.storeinventory.model.Fruit
import com.example.storeinventory.screens.SharedListDetailViewModel

/**
 * A [Fragment] containing adding fruits to the inventory
 */
class DetailFragment : Fragment() {
    private val TAG: String = javaClass.simpleName

    private lateinit var viewModel: SharedListDetailViewModel
    private lateinit var binding: FragmentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_detail,
            container,
            false
        )

        // Get the viewmodel
        viewModel = ViewModelProvider(this).get(SharedListDetailViewModel::class.java)

        // Allow layout access to VieWModel
        binding.sharedListDetailViewModel = viewModel

        // Navigation
        setupNavigation()

        return binding.root
    }

    // Navigation
    private fun setupNavigation() {
        viewModel.eventCancelFruit.observe(viewLifecycleOwner, EventObserver {
            findNavController().navigate(
                DetailFragmentDirections
                    .actionDetailDestinationToListDestination()
            )
        })

        viewModel.eventSaveFruit.observe(viewLifecycleOwner, EventObserver {
            findNavController().navigate(
                DetailFragmentDirections
                    .actionDetailDestinationToListDestination()
            )
        })
    }

}