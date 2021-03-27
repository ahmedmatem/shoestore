package com.udacity.shoestore.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe
import timber.log.Timber

class ShoeListViewModel : ViewModel() {

    private lateinit var _shoeList: MutableLiveData<Collection<Shoe>>
    val shoeList: LiveData<Collection<Shoe>>
        get() = _shoeList

    init {
        setShoeList()
    }

    private fun setShoeList() {
        _shoeList.value = listOf(
            Shoe("Adidas", 7.5, "Adidas", "Description", listOf("img_1", "img_2")),
            Shoe("Adidas", 7.5, "Adidas", "Description", listOf("img_1", "img_2")),
            Shoe("Adidas", 7.5, "Adidas", "Description", listOf("img_1", "img_2")),
            Shoe("Adidas", 7.5, "Adidas", "Description", listOf("img_1", "img_2")),
            Shoe("Adidas", 7.5, "Adidas", "Description", listOf("img_1", "img_2")),
            Shoe("Adidas", 7.5, "Adidas", "Description", listOf("img_1", "img_2")),
        )
    }
}