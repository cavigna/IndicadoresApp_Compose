package com.example.indicadoresapp.viewmodel

import androidx.lifecycle.asLiveData
import com.example.indicadoresapp.db.IndiceDao
import com.example.indicadoresapp.model.entity.Euro
import com.example.indicadoresapp.network.ApiService
import com.example.indicadoresapp.utils.*

class Repositorio(private val api: ApiService, private val dao: IndiceDao) {

    private suspend fun listadoUFAPI() = api.listadoIndicadorAnual("uf", 2021)
    private suspend fun listadoDolarAPI() = api.listadoIndicadorAnual("dolar", 2021)
    private suspend fun listadoEuroAPI() = api.listadoIndicadorAnual("euro", 2021)
    private suspend fun listadoUTMAPI() = api.listadoIndicadorAnual("utm", 2021)

    suspend fun agregarDB() {
        dao.agregarListadoUF(convertirUfEntidad(listadoUFAPI().serie))
        dao.agregarListadoDolar(convertirDolarEntidad(listadoDolarAPI().serie))
        dao.agregarListadoEuro(convertirEuroEntidad(listadoEuroAPI().serie))
        if(listadoUTM().asLiveData().value?.isEmpty() == true) {
            dao.agregarListadoUTM(convertirUTMEntidad(listadoUTMAPI().serie))
        }
    }


    fun listadoUF() = dao.listadoUFDB()
    fun listadoDolar() = dao.listadoDolar()
    fun listadoEuro() = dao.listadoEuro()
    fun listadoUTM() = dao.listadoUTMDB()
    fun ufHoy() = dao.ufHoy(hoyDia())



}


/*
    suspend fun traerUFanualAPI() = api.listadoUFAnual()

    suspend fun agregarListadoDB(){
        val listado = traerUFanualAPI().uFs

        dao.agregarListadoUF(listado)
    }

    fun listadoUFDB() = dao.listadoUFDB()
 */