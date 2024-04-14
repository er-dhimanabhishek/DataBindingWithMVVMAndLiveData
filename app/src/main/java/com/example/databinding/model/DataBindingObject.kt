package com.example.databinding.model

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "data_binding_tbl")
data class DataBindingObject(@PrimaryKey @Bindable var title: String, var desc: String) : BaseObservable()
