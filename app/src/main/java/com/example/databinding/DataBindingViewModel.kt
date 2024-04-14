package com.example.databinding

import android.content.Context
import android.os.Handler
import android.os.Looper
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.databinding.model.DataBindingObject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class DataBindingViewModel(ctx: Context): ViewModel() {

    var _repository = DataBindingRepository(ctx)

    val dataBindingObservableObject : LiveData<DataBindingObject>
        get() = _repository.dataBindingData

    fun setDataValue(){
        _repository.setValue(DataBindingObject("Nature", "Clear skies, blue birds fly."))
    }

    fun updateDataBindingObject(){
        viewModelScope.launch(Dispatchers.IO) {
            _repository.insertData(DataBindingObject("Space", "Mercury, Venus, Earth, Mars."))
            delay(2000)
            _repository.getData()
        }
    }

    fun getDataFromDB(){
        viewModelScope.launch(Dispatchers.IO) {
            _repository.getData()
        }
    }

}