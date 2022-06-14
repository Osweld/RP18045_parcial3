package com.example.rp18045_parcial3.dao

import com.google.gson.annotations.SerializedName

data class Vehiculo(
    var matricula : String,
    var propietario : String,
    var marca : Int,
    var color : String,
    var anio : String
)
