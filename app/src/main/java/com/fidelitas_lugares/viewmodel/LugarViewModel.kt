package com.fidelitas_lugares.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.fidelitas_lugares.data.LugarDAO
import com.fidelitas_lugares.model.Lugar
import com.fidelitas_lugares.repositorio.LugarRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class lugarViewModel(application: Application) : AndroidViewModel(application) {

    val getAllData: MutableLiveData<List<Lugar>>
    private var repository: LugarRepository = LugarRepository(LugarDAO())

    init{
        getAllData = repository.getAllData
    }

    fun SaveLugar(lugar: Lugar){
        viewModelScope.launch (Dispatchers.IO){
            repository.SaveLugar(lugar)
        }
    }

}