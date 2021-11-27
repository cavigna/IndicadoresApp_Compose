package com.example.indicadoresapp.app

import android.app.Application
import com.example.indicadoresapp.db.BaseDeDatos
import com.example.indicadoresapp.network.ApiService
import com.example.indicadoresapp.utils.leerArchivo
import com.example.indicadoresapp.viewmodel.Repositorio
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class IndiApp: Application() {

    private val retrofitClient by lazy {
        Retrofit.Builder()
            .baseUrl("https://mindicador.cl/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

    private val database by lazy {  BaseDeDatos.getDataBase(this) }

    val repositorio by lazy { Repositorio(retrofitClient, database.dao()) }


}