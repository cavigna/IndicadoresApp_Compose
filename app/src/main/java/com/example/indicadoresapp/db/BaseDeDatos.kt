package com.example.indicadoresapp.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.indicadoresapp.model.entity.Dolar
import com.example.indicadoresapp.model.entity.Euro
import com.example.indicadoresapp.model.entity.UF
import com.example.indicadoresapp.model.entity.UTM

@Database(entities = [UF::class, Dolar::class, Euro::class, UTM::class],
    version = 1, exportSchema = false)
abstract class BaseDeDatos : RoomDatabase() {
    abstract fun dao() : IndiceDao

    companion object {

        @Volatile
        private var INSTANCE: BaseDeDatos? = null

        fun getDataBase(context: Context): BaseDeDatos {

            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    BaseDeDatos::class.java,
                    "indice_db"
                )
                    .build()
                INSTANCE = instance

                instance
            }
        }
    }
}