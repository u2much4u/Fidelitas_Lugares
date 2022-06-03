package com.fidelitas_lugares.repositorio

import androidx.lifecycle.LiveData
import com.fidelitas_lugares.data.LugarDAO
import com.fidelitas_lugares.model.Lugar


//(SEMANA 3)Se implementan las funcionas de la interfase
class LugarRepository(private val  lugarDAO: LugarDAO) {

    val getAllData: LiveData<List<Lugar>> = lugarDAO.getAllData()

    fun addLugar(lugar: Lugar){
        suspend {  lugarDAO.addLugar(lugar)}
    }

    fun updateLugar(lugar: Lugar){
        suspend {  lugarDAO.updateLugar(lugar)}
    }

    fun deleteLugar(lugar: Lugar){
        suspend {  lugarDAO.deleteLugar(lugar)}
    }

}