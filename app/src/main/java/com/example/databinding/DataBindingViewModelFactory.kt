package com.example.databinding

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class DataBindingViewModelFactory(private val ctx: Context): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DataBindingViewModel::class.java)) {
            return DataBindingViewModel(ctx) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}