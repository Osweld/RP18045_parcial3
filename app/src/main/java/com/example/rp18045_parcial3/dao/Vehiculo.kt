package com.example.rp18045_parcial3.dao

import com.google.gson.annotations.SerializedName

data class Vehiculo(
    @SerializedName("matricula")
    var matricula : String,
    @SerializedName("propietario")
    var propietario : String,
    @SerializedName("marca")
    var marca : Int,
    @SerializedName("color")
    var color : String,
    @SerializedName("anio")
    var anio : String
)
