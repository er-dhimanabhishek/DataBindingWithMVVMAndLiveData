package com.example.databinding.roomdb

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.databinding.model.DataBindingObject

@Database(entities = [DataBindingObject::class], version = 1, exportSchema = false)
abstract class DataBindingRoomDB: RoomDatabase() {

    abstract fun dataBindingDao(): DataBindingDao

    companion object{
        @Volatile
        private var INSTANCE: DataBindingRoomDB? = null

        fun getInstance(context: Context): DataBindingRoomDB{
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(context.applicationContext,
                    DataBindingRoomDB::class.java,
                "data_binding.db").build()
                INSTANCE = instance
                instance
            }
        }
    }

}