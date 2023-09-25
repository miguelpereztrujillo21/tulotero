package com.example.tulotero.modules

import android.app.Application
import androidx.room.Room
import com.example.tulotero.modules.adapters.db.AdminsDatabase

class App: Application() {
    companion object {
        lateinit var instance: App private set
        lateinit var db: AdminsDatabase
    }

    override fun onCreate() {
        super.onCreate()
        instance = this

        db = Room.databaseBuilder(
            instance,
            AdminsDatabase::class.java,
            "order-database.db"
        ).fallbackToDestructiveMigration().build()
    }
}