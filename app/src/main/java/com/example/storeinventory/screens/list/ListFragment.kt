package com.example.storeinventory.screens.list

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.storeinventory.EventObserver
import com.example.storeinventory.screens.SharedListDetailViewModel
import com.example.storeinventory.R
import com.example.storeinventory.databinding.FragmentListBinding

class ListFragment : Fragment() {
    private val TAG: String = javaClass.simpleName

    private lateinit var viewModel: SharedListDetailViewModel
    private lateinit var binding: FragmentListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_list,
            container,
            false
        )

        // Get the ViewModel
        viewModel = ViewModelProvider(this).get(SharedListDetailViewModel::class.java)

        // Allow layout access to VieWModel
        binding.sharedListDetailViewModel = viewModel

        // Binding can observe LiveData updates
        binding.lifecycleOwner = this

        // Navigation
        setupNavigateToDetail()

        createFruitList()

        return binding.root
    }

    private fun setupNavigateToDetail() {
        viewModel.eventAddFruit.observe(viewLifecycleOwner, EventObserver {
            findNavController().navigate(
                ListFragmentDirections
                    .actionListDestinationToDetailDestination()
            )
        })
    }

    private fun createFruitList() {
        val fruitListView = binding.linearListFruits

        viewModel.fruitList.value?.forEach {
            // inflate fruit item layout
            val fruitListItemLayout = View.inflate(
                context,
                R.layout.item_fruit,
                fruitListView
            )

            fruitListView.addView(fruitListItemLayout)
        }
    }
}