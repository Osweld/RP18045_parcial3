package com.example.rp18045_parcial3

import com.example.rp18045_parcial3.dao.Caracteres
import com.example.rp18045_parcial3.dao.Conductor
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import java.util.*

interface APIInterface {
    @GET("/caracteres/{caracteres}")
    suspend fun getCaracteres(@Path("caracteres") caracteres: String): Response<Caracteres>

    @GET("/conductor/{licencia}")
    suspend fun getVehiculosPorConductor(@Path("licencia") licencia: String): Response<Conductor>
}