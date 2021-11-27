package com.example.indicadoresapp.model.entity


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "utm_tabla")
data class UTM(
    @PrimaryKey
    var fecha: String = "",

    var valor: Double = 0.0
)