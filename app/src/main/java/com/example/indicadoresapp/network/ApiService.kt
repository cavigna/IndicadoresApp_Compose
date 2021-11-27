package com.example.indicadoresapp.network


import com.example.indicadoresapp.BuildConfig
import com.example.indicadoresapp.model.IndicadorResponse
import com.example.indicadoresapp.network.borrador.UFResponse
import retrofit2.http.GET
import retrofit2.http.Path

import retrofit2.http.Query


interface ApiService {

    companion object{
        val APIKEY = BuildConfig.API_KEY
    }

    @GET("{indicador}/{year}")
    suspend fun listadoIndicadorAnual(
        @Path("indicador") indicador :String,
        @Path("year") year: Int

    ) : IndicadorResponse
}


/*
    @GET("uf/2021")
    suspend fun listadoUFAnual(
        @Query(value = "apikey") apikey: String = APIKEY,
        @Query(value = "formato") formato:String = "json"
    ) : UFResponse
 */