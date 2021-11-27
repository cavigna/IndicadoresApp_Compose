package com.example.indicadoresapp.model.api


import com.google.gson.annotations.SerializedName

data class Serie(
    @SerializedName("fecha")
    var fecha: String = "",
    @SerializedName("valor")
    var valor: Double = 0.0
)