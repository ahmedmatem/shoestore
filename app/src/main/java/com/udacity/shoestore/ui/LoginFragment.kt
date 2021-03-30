package com.udacity.shoestore.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentLoginBinding
import com.udacity.shoestore.viewmodels.ShoeViewModel

/**
 * A simple [Fragment] subclass.
 */
class LoginFragment : Fragment() {
    private val shoeViewModel by activityViewModels<ShoeViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentLoginBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_login, container, false
        )

        shoeViewModel.shoes?.value?.clear()

        val buttons = listOf<Button>(binding.loginBtn, binding.registerBtn)
        buttons.forEach { btn ->
            btn.setOnClickListener { view ->
                view.findNavController().navigate(R.id.action_loginFragment_to_welcomeFragment)
            }
        }
        return binding.root
    }
}