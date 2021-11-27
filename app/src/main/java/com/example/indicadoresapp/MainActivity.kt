package com.example.indicadoresapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.indicadoresapp.app.IndiApp
import com.example.indicadoresapp.ui.compose.HomeCompose
import com.example.indicadoresapp.ui.theme.IndicadoresAppTheme
import com.example.indicadoresapp.ui.theme.blueBackground
import com.example.indicadoresapp.viewmodel.IndiModelFactory
import com.example.indicadoresapp.viewmodel.IndiViewModel

class MainActivity : ComponentActivity() {
    private val viewModel by viewModels<IndiViewModel> {
        IndiModelFactory((application as IndiApp).repositorio)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e("prueba", "dia")

        setContent {
            //val ufvalor = viewModel.ufApi.value.uFs[0].valor
//            val ufvalor = viewModel.ufApi.value.toString()
//            Log.i("prueba", ufvalor)

            viewModel.listadoUFLD.observe(this,{

            })
            IndicadoresAppTheme {



                Surface(color = blueBackground) {
                    HomeCompose(viewModel = viewModel, ufValor = viewModel.listadoUf.component1()[0].valor.toString())
                    //HomeCompose(viewModel = viewModel, ufValor = viewModel.listadoUf2.value[0].valor.toString())




                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    IndicadoresAppTheme {
     //   ArtistCard()
        //Tarjeta()
    }
}