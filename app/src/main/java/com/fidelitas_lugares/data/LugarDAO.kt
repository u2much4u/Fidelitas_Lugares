package com.fidelitas_lugares.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.fidelitas_lugares.model.Lugar
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreSettings
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase


class LugarDAO {

    private val coleccion1 = "lugaresApp"
    private val usuario = Firebase.auth.currentUser?.email.toString()
    private val coleccion2 = "misLugares"

    //Obtener la instancia
    private var Firestore = FirebaseFirestore.getInstance()

    init {
        Firestore.firestoreSettings = FirebaseFirestoreSettings.Builder().build()
    }

    fun getAllData() : MutableLiveData<List<Lugar>> {
        val lst = MutableLiveData<List<Lugar>>()
        Firestore.collection(coleccion1).document(usuario).collection(coleccion2)
            .addSnapshotListener { instantanea, e ->
                if (e != null)
                    return@addSnapshotListener
                if (instantanea != null) {
                    val lstAux = ArrayList<Lugar>()
                    instantanea.documents.forEach {
                        val entLugar = it.toObject(Lugar::class.java)
                        if (entLugar != null) {
                            lstAux.add(entLugar)
                        }
                    }
                lst.value = lstAux
                }
            }
        return lst
    }


     fun SaveLugar(lugar: Lugar){
        val documento : DocumentReference
        if(lugar.id.isEmpty()){
            documento = Firestore.collection(coleccion1).document(usuario).collection(coleccion2).document()
            lugar.id = documento.id
        } else{
            documento = Firestore.collection(coleccion1).document(usuario).collection(lugar.id).document()
        }
        documento.set(lugar).addOnSuccessListener {
            Log.d("saveLugar", "Lugar agregado/modificado")
        }
    }
}