package com.example.tulotero.modules.adapters.db


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.tulotero.modules.models.AdminDao
import com.example.tulotero.modules.models.Administration

@Database(entities = [Administration::class], version = 1, exportSchema = false)
abstract class AdminsDatabase : RoomDatabase() {

    abstract fun adminDao(): AdminDao


    companion object {
        @Volatile
        private var instance: AdminsDatabase? = null
        private var LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: getDataBase(context).also { instance = it }
        }

        @Synchronized
        fun getDataBase(context: Context): AdminsDatabase {
            return instance ?: synchronized(this) {
                Room.databaseBuilder(context, AdminsDatabase::class.java, "admin_database")
                    .build()

            }
        }


    }


}