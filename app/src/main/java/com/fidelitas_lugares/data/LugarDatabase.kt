package com.fidelitas_lugares.data

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.fidelitas_lugares.model.Lugar


@Database(entities = [Lugar::class], version = 1, exportSchema = false)
abstract class LugarDatabase : RoomDatabase(){
    abstract fun lugarDAO() : LugarDAO

    //Constructor estático
    companion object{

        @Volatile
        private var INSTANCE : LugarDatabase?= null

        //Devuelve la base de datos (String conexión URL)
        fun getDatabase (Context: android.content.Context) : LugarDatabase{
            val tempInstance = INSTANCE

            if(tempInstance != null){
                return tempInstance
            }

            synchronized(this){
                return Room.databaseBuilder(Context.applicationContext, LugarDatabase::class.java,"Lugar_DataBase").build()
            }
        }
    }
}