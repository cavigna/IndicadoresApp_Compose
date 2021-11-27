package com.example.indicadoresapp.utils

import android.content.Context
import com.example.indicadoresapp.model.api.Serie
import com.example.indicadoresapp.model.entity.Dolar
import com.example.indicadoresapp.model.entity.Euro
import com.example.indicadoresapp.model.entity.UF
import com.example.indicadoresapp.model.entity.UTM
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.BufferedReader
import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.roundToInt


fun convertirJsonToUfDb(ufString: String): UF {
    val type = object :TypeToken<UF>(){}.type
    return Gson().fromJson(ufString, type)
}

fun leerArchivo( context: Context, fileName:String):String{
    return context
        .assets
        .open(fileName)
        .bufferedReader()
        .use(BufferedReader::readText)

}
fun convertirFechaLoca(fechaLoca: String):String{
    val date = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").parse(fechaLoca)
    return SimpleDateFormat("dd-MM-yyyy").format(date)
}

fun convertirUfEntidad(list: List<Serie>): List<UF>{
    val listado = mutableListOf<UF>()

    list.forEach {
        val fecha = convertirFechaLoca(it.fecha)

        listado.add(UF(fecha, it.valor))
    }

    return listado
}

fun convertirDolarEntidad(list: List<Serie>): List<Dolar>{
    val listado = mutableListOf<Dolar>()

    list.forEach {
        val fecha = convertirFechaLoca(it.fecha)

        listado.add(Dolar(fecha, it.valor))
    }

    return listado
}

fun convertirEuroEntidad(listaApi: List<Serie>):List<Euro>{
    val listadoReturn = mutableListOf<Euro>()
    listaApi.forEach {
        listadoReturn.add(Euro(convertirFechaLoca(it.fecha), it.valor))
    }
    return listadoReturn

}


fun convertirUTMEntidad(listaApi: List<Serie>):List<UTM>{
    val listadoReturn = mutableListOf<UTM>()
    listaApi.forEach {
        listadoReturn.add(UTM(convertirFechaLoca(it.fecha), it.valor))
    }
    return listadoReturn

}


fun montoToCLP(monto: Double?):String{
    val format: NumberFormat = NumberFormat.getCurrencyInstance(Locale("es", "CL"))
    format.maximumFractionDigits = 0
    return format.format(monto!!.roundToInt())
}




fun hoyDia():String{
    val today = Calendar.getInstance().time
    val formatter = SimpleDateFormat("dd-MM-yyyy")
    return formatter.format(today)
}



