package com.udacity.shoestore.ui

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.TextView
import androidx.core.view.setPadding
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoesBinding
import com.udacity.shoestore.databinding.ShoeItemBinding
import com.udacity.shoestore.viewmodels.ShoeViewModel

/**
 * A simple [Fragment] subclass.
 */
class ShoesFragment : Fragment() {
    private lateinit var binding: FragmentShoesBinding
    private val _shoeViewModel by activityViewModels<ShoeViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_shoes, container, false
        )

        setHasOptionsMenu(true)

        _shoeViewModel.shoes.observe(viewLifecycleOwner, { shoes ->
            if(shoes.isNotEmpty()){
                shoes.forEach { shoe ->
                    val shoeItemBinding = ShoeItemBinding.inflate(
                        layoutInflater, null, false
                    )
                    shoeItemBinding.shoe = shoe
                    binding.shoeListContainer.addView(shoeItemBinding.root)
                }
            }
        })

        binding.fab.setOnClickListener { view ->
            view.findNavController().navigate(R.id.action_shoesFragment_to_detailFragment)
        }

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.main_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController()) ||
                super.onOptionsItemSelected(item)
    }
}