package com.example.indicadoresapp.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "euro_tabla")
data class Euro(
    @PrimaryKey
    var fecha: String = "",

    var valor: Double = 0.0
)
