package com.example.databinding

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.databinding.model.DataBindingObject
import com.example.databinding.roomdb.DataBindingDao
import com.example.databinding.roomdb.DataBindingRoomDB

class DataBindingRepository(ctx: Context) {

    private var dataBindingDao: DataBindingDao
    private val database = DataBindingRoomDB.getInstance(ctx)

    init {
        dataBindingDao = database.dataBindingDao()
    }

    val _dataBindingLiveData = MutableLiveData<DataBindingObject>()
    val dataBindingData : LiveData<DataBindingObject>
        get() = _dataBindingLiveData

    fun setValue(data: DataBindingObject){
        _dataBindingLiveData.value = data
    }

    suspend fun insertData(data: DataBindingObject){
        dataBindingDao.insertData(data)
    }

    suspend fun getData(){
        _dataBindingLiveData.postValue(dataBindingDao.getData())
    }

}