package com.udacity.shoestore.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentDetailBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.viewmodels.ShoeViewModel

/**
 * A simple [Fragment] subclass.
 */
class DetailFragment : Fragment() {
    private val _shoeViewModel by activityViewModels<ShoeViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentDetailBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_detail, container, false
        )
        binding.cancelBtn.setOnClickListener { view ->
            view.findNavController().navigate(R.id.action_detailFragment_to_shoesFragment)
        }

        binding.shoe = Shoe("", 0.0, "", "")
        binding.detailFragment = this

        return binding.root
    }

    fun saveShoe(item: Shoe){
        _shoeViewModel.onSave(item)
        this.findNavController().navigate(R.id.action_detailFragment_to_shoesFragment)
    }
}