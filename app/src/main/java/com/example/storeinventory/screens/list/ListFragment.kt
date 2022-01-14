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
import com.example.storeinventory.databinding.ItemFruitBinding

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
        viewModel = ViewModelProvider(requireActivity()).get(SharedListDetailViewModel::class.java)

        // Allow layout access to VieWModel
        binding.sharedListDetailViewModel = viewModel

        // Binding can observe LiveData updates
        binding.lifecycleOwner = this

        // Navigation
        setupNavigateToDetail()

        viewModel.fruitList.observe(viewLifecycleOwner, {
            createFruitList()
        })

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
            val fruitListItemLayout: ItemFruitBinding = DataBindingUtil.inflate(
                layoutInflater,
                R.layout.item_fruit,
                fruitListView,
                false
            )

            fruitListItemLayout.textViewNameList.text = it.name
            fruitListItemLayout.textViewCompanyList.text = it.company
            fruitListItemLayout.textViewKgList.text =
                getString(R.string.list_item_quantity_kg, it.kilos)
            fruitListItemLayout.textViewDescList.text = it.description

            fruitListView.addView(fruitListItemLayout.root)
        }
    }
}