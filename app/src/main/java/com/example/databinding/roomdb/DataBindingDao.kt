package com.example.databinding.roomdb

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.REPLACE
import androidx.room.Query
import com.example.databinding.model.DataBindingObject

@Dao
interface DataBindingDao {

    @Insert(onConflict = REPLACE)
    suspend fun insertData(data: DataBindingObject)

    @Query("SELECT * FROM data_binding_tbl LIMIT 1")
    suspend fun getData(): DataBindingObject

}