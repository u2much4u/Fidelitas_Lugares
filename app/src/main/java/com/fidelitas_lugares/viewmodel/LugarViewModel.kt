package com.fidelitas_lugares.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.fidelitas_lugares.data.LugarDAO
import com.fidelitas_lugares.data.LugarDatabase
import com.fidelitas_lugares.model.Lugar
import com.fidelitas_lugares.repositorio.LugarRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

//(Semana 3) Funciones de alto nivel
class lugarViewModel(application: Application) : AndroidViewModel(application) {

    val getAllData: LiveData<List<Lugar>>
    private val repository: LugarRepository

    init{
        val LugarDAO = LugarDatabase.getDatabase(application).lugarDAO()
        repository = LugarRepository(LugarDAO)
        getAllData = repository.getAllData
    }

    fun addLugar(lugar: Lugar){
        viewModelScope.launch (Dispatchers.IO){
            repository.addLugar(lugar)
        }
    }

    fun updateLugar(lugar: Lugar){
        viewModelScope.launch (Dispatchers.IO){
            repository.updateLugar(lugar)
        }
    }

    fun deleteLugar(lugar: Lugar){
        viewModelScope.launch (Dispatchers.IO){
            repository.deleteLugar(lugar)
        }
    }


}