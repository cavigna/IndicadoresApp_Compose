package com.example.indicadoresapp.viewmodel

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.*
import com.example.indicadoresapp.model.entity.Dolar
import com.example.indicadoresapp.model.entity.UF
import com.example.indicadoresapp.model.entity.UTM
import kotlinx.coroutines.launch
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.collect
import java.net.SocketTimeoutException


class IndiViewModel(private val repositorio: Repositorio) : ViewModel() {

    //var ufApi by remember { mutableStateOf(UFResponse()) }
    //var listadoDolar by remember { mutableStateOf(listOf(Dolar())) }
    //var listadoDolar = mutableStateOf(listOf(Dolar()))

    val listadoUFLD = repositorio.listadoUF().asLiveData()
    var listadoUf = mutableStateOf(listOf(UF()))
    val ufHOYLD = repositorio.ufHoy().asLiveData()
    var ufHoy = mutableStateOf(UF())

    //var listadoDolars = mutableStateListOf<Dolar>()

    var listadoDolar = repositorio.listadoDolar()
    var listadoEuro = repositorio.listadoEuro()
    var listadoUtm = repositorio.listadoUTM()


    var prueba = repositorio.listadoUTM().collectAsState(listOf())




//    private val _isLoading = MutableStateFlow(true)
//    val isLoading: StateFlow<Boolean> = _isLoading





    init {

        viewModelScope.launch(IO) {
            try {
                repositorio.agregarDB()
            } catch (socket: SocketTimeoutException){

            }



            //listadoUf.value = listadoUFLD.value!!
            //listadoDolar.set(repositorio.listadoDolar().asLiveData().value)
            //ufHoy.value = ufHOYLD.value!!

//            listadoDolar.value = repositorio.listadoDolar().asLiveData().value!!
            // ufHoyFun()
            //ufHoy.value = repositorio.ufHoy().asLiveData().value!!
            //ufHoy.c = repositorio.ufHoy().asLiveData().value?.get(0)!!.valor


        }


    }


    private fun agregarDB() {
        viewModelScope.launch {
            repositorio.agregarDB()
            listadoUf.value = listadoUFLD.value!!
        }
    }

    private fun ufHoyFun() {
        viewModelScope.launch {
            val algo = repositorio.ufHoy().asLiveData().value
            //ufHoy.value = algo!![0]
        }
    }


}

class IndiModelFactory(private val repositorio: Repositorio) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return IndiViewModel(repositorio) as T
    }

}

/*
    private fun agregarDB(){
        viewModelScope.launch {
            repositorio.agregarListadoDB()
        }
    }


    private  fun traerUFApi() {
        viewModelScope.launch {
          ufApi.value =repositorio.traerUFanualAPI()
        }
    }
 */