package com.udacity.shoestore.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeViewModel : ViewModel() {

    private val _shoes = MutableLiveData(ArrayList<Shoe>())
    val shoes: LiveData<ArrayList<Shoe>>
        get() = _shoes

    fun onSave(item: Shoe){
        _shoes.value?.add(item)
    }
}