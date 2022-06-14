package com.example.rp18045_parcial3.dao

import com.google.gson.annotations.SerializedName

data class Conductor(
    @SerializedName("licencia")
    var licencia : String,
    @SerializedName("nombre")
    var nombre : String,
    @SerializedName("edad")
    var edad : Int,
    @SerializedName("estado_civil")
    var estado_civil : String,
    @SerializedName("tipo_licencia")
    var tipo_licencia : String,
    @SerializedName("vehiculos")
var vehiculos : List<Vehiculo>


)
