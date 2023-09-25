package com.example.tulotero.modules.modules

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tulotero.modules.App
import com.example.tulotero.modules.api.Api
import com.example.tulotero.modules.api.RetrofitHelper
import com.example.tulotero.modules.models.Administration
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    var administrations = MutableLiveData<ArrayList<Administration>>()
    var error = MutableLiveData<String>()
    var searchText = MutableLiveData<String>()


    fun getAdminitrations() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = RetrofitHelper.getInstance().create(Api::class.java).getAdmins()
                if (response.isSuccessful) {
                    response.body()?.forEach { admin ->
                        insertAdmin(admin)
                    }

                } else {
                    error.postValue(response.code().toString())
                }
            } catch (e: Exception) {
                error.value = "Error: ${e.message}"
            }

        }

    }

    private fun insertAdmin(admin: Administration) {
        CoroutineScope(Dispatchers.IO).launch {
            App.db.adminDao().insert(admin)

        }
    }

    fun getAllRoomAdmins() {
        CoroutineScope(Dispatchers.IO).launch {
            App.db.adminDao().getAllItems().collect { items ->
                administrations.postValue(items as ArrayList<Administration>?)
            }
        }
    }

    fun getRoomAdminByName(name: String) {
        CoroutineScope(Dispatchers.IO).launch {
            App.db.adminDao().getAdminsBySearchText(name).collect { items ->
                administrations.postValue(items as ArrayList<Administration>?)
            }
        }
    }
}