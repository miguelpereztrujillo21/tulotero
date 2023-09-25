package com.example.tulotero.modules.api

import com.example.tulotero.modules.models.Administration
import retrofit2.Response
import retrofit2.http.GET

interface Api {

    @GET("admins")
    suspend fun getAdmins():Response<ArrayList<Administration>>


}