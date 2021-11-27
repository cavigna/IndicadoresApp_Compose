package com.example.indicadoresapp.ui.compose

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.asLiveData
import com.example.indicadoresapp.model.entity.Dolar
import com.example.indicadoresapp.ui.theme.*
import com.example.indicadoresapp.utils.montoToCLP
import com.example.indicadoresapp.viewmodel.IndiViewModel


//@Preview(showBackground = true)
@Composable
fun HomeCompose(
    modifier: Modifier = Modifier,
    ufValor: String = "",
    viewModel: IndiViewModel
) {
    //var ufValue = viewModel.ufApi.value.uFs[0].valor
     //val dolarValue by  viewModel.listadoDolar.collectAsState(listOf())
    //val dolar = viewModel.listadoDolar.asLiveData().value?.get(0)?.valor.toString()
    // var dolarValue by  remember { mutableStateOf(0.0) }


    //val valorUF = viewModel.listadoUFLD.observeAsState().value?.get(0)?.valor
    val valorDolar = viewModel.listadoDolar.asLiveData().observeAsState().value?.get(0)?.valor
    val valorUF = viewModel.ufHOYLD.observeAsState().value?.valor
    val valorEuro = viewModel.listadoEuro.asLiveData().observeAsState().value?.get(0)?.valor
    //val valorUtm = viewModel.listadoUtm.asLiveData().observeAsState().value?.get(1)?.valor
    val valorUtm by viewModel.prueba




    Surface( color = blueBackground, modifier = modifier.fillMaxSize()) {
        Column {

            Row(
                modifier.padding(top = 10.dp, bottom = 40.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    "Indicadores De Chile", //viewModel.ufApi.component1().uFs[0].valor
                    fontSize = 50.sp,
                    fontFamily = FontFamily.Monospace,
                    color = Color.White,
                    textAlign = TextAlign.Center


                    )
            }

            Row(modifier = modifier.fillMaxSize()) {

                Column {
                    Tarjeta(titulo = "USD", monto = valorDolar.toString())
                    Tarjeta(titulo = "UF", color = yellowCard, monto = valorUF.toString())


                }
                Column {
                    Tarjeta(titulo = "EURO", color = purpleCard, monto = valorEuro.toString())
                    Tarjeta(titulo = "UTM", color = pinkCardFuchsia, monto = valorUtm.toString())


                }
            }


        }
    }
}

@Composable
fun Tarjeta(
    modifier: Modifier = Modifier,
    titulo: String,
    monto: String = "123",
    color: Color = greenCard,

    ) {
    Surface(modifier = modifier.padding(10.dp), color = blueBackground) {
        Card(
            modifier = modifier.size(175.dp, 125.dp).padding(5.dp),
            shape = RoundedCornerShape(10.dp),
            backgroundColor = color,

            ) {
            Column(
                modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = titulo,
                    fontSize = 25.sp,
                    color = Color.White
                )
                Text(
                    text = monto,
                    fontSize = 25.sp,
                    color = Color.White)
            }
        }
    }

}