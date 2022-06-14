package com.example.rp18045_parcial3.dao

import com.google.gson.annotations.SerializedName

data class Caracteres(
    @SerializedName("caracteres")
    var caracteres : String,
    @SerializedName("nombre")
    var total : Int,
)
