package com.fidelitas_lugares.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.fidelitas_lugares.model.Lugar

@Dao
interface LugarDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addLugar(lugar: Lugar)

    @Update(onConflict = OnConflictStrategy.IGNORE)
    suspend fun updateLugar(lugar: Lugar)

    @Delete
    suspend fun deleteLugar(lugar: Lugar)

    @Query ("SELECT * FROM LUGAR")
    fun  getAllData() : LiveData<List<Lugar>>

}