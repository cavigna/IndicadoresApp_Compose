package com.example.indicadoresapp.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "dolar_tabla")
data class Dolar(
    @PrimaryKey
    var fecha: String = "",

    var valor: Double = 0.0
)
