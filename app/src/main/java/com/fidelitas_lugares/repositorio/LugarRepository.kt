package com.fidelitas_lugares.repositorio

import androidx.lifecycle.MutableLiveData
import com.fidelitas_lugares.data.LugarDAO
import com.fidelitas_lugares.model.Lugar


class LugarRepository(private val lugarDAO: LugarDAO) {

    val getAllData: MutableLiveData<List<Lugar>> = lugarDAO.getAllData()

    fun saveLugar(lugar: Lugar){
        suspend {  lugarDAO.SaveLugar(lugar)}
    }

}