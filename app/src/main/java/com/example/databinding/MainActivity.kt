package com.example.databinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.databinding.databinding.ActivityMainBinding
import com.example.databinding.model.DataBindingObject

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    lateinit var dataBindingViewModel: DataBindingViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = DataBindingUtil.setContentView(
            this, R.layout.activity_main
        )
        dataBindingViewModel = ViewModelProvider(
            this, DataBindingViewModelFactory(this)
        )[DataBindingViewModel::class.java]
        _binding?.dataBindingViewModel = dataBindingViewModel
        _binding?.lifecycleOwner = this
        dataBindingViewModel.setDataValue()
        /*_binding?.btnUpdate?.setOnClickListener {
            dataBindingViewModel.updateDataBindingObject()
            Handler(Looper.myLooper()!!).postDelayed({
                dataBindingViewModel.getDataFromDB()
            }, 2000)
        }*/
    }
}