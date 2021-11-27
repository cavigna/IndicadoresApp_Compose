package com.example.indicadoresapp.model


import com.example.indicadoresapp.model.api.Serie
import com.google.gson.annotations.SerializedName

data class IndicadorResponse(
    @SerializedName("autor")
    var autor: String = "",
    @SerializedName("codigo")
    var codigo: String = "",
    @SerializedName("nombre")
    var nombre: String = "",
    @SerializedName("serie")
    var serie: List<Serie> = listOf(),
    @SerializedName("unidad_medida")
    var unidadMedida: String = "",
    @SerializedName("version")
    var version: String = ""
)