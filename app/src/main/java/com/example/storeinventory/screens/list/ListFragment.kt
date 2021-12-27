package com.example.storeinventory.screens.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.storeinventory.R
import com.example.storeinventory.databinding.FragmentListBinding

class ListFragment : Fragment() {
    private lateinit var viewModel: ListViewModel
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

        // Get the viewmodel
        viewModel = ViewModelProvider(this).get(ListViewModel::class.java)

        // Allow layout access to VieWModel
        binding.listViewModel = viewModel

        // Binding can observe LiveData updates
        binding.lifecycleOwner = this

        return binding.root
    }
}