package com.fidelitas_lugares.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName="Lugar")
data class Lugar(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    @ColumnInfo(name="Nombre")
    val nombre:String,
    @ColumnInfo(name="Correo")
    val correo:String?,
    @ColumnInfo(name="Telefono")
    val telefono:String?,
    @ColumnInfo(name="Latitud")
    val latitud:Double?,
    @ColumnInfo(name="Longitud")
    val longitud:Double?,
    @ColumnInfo(name="Altura")
    val altura:Double?,
    @ColumnInfo(name="RutaAudio")
    val rutaAudio:String?,
    @ColumnInfo(name="RutaImagen")
    val rutaImagen:String?,
): Parcelable
