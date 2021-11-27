package com.example.indicadoresapp.network.borrador


import com.example.indicadoresapp.model.entity.UF
import com.google.gson.annotations.SerializedName

data class UFResponse(
    @SerializedName("UFs")
    var uFs: List<UF> = listOf()
)