package com.example.tulotero.modules.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "admins")
data class Administration(
    @PrimaryKey
    val id: String,
    @SerializedName("nombre")
    val name: String? = null,
    @SerializedName("urlFoto")
    val urlPhoto: String? = null,
    @SerializedName("telefono")
    val phone: String? = null,
    @SerializedName("poblacion")
    val town: String? = null,
    @SerializedName("direccion")
    val address: String? = null,
    @SerializedName("provincia")
    val province: String? = null,
    @SerializedName("codigoPostal")
    val postalCode: String? = null, @SerializedName("licenciaNombre")
    val licenceName: String? = null,
    @SerializedName("licenciaApellidos")
    val licenceLastName: String? = null,
    @SerializedName("licenciaDni")
    val licenceDni: String? = null,
    @SerializedName("numero")
    val number: String? = null,
    @SerializedName("comercial")
    val commercial: String? = null
) {


}