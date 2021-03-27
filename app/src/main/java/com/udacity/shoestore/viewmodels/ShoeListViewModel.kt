package com.udacity.shoestore.viewmodels

import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe
import timber.log.Timber

class ShoeListViewModel : ViewModel() {

    private val shoeList: MutableList<Shoe> = mutableListOf(
        Shoe("Adidas", 7.0, "Adidas", "Description", listOf("image1", "image2"))
    )
}