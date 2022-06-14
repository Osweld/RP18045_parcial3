package com.example.rp18045_parcial3

import retrofit2.Response
import retrofit2.http.GET
import java.util.*

interface APIInterface {
    @GET("/caracteres/")
    suspend fun getAllUsers(): Response<Objects>
}