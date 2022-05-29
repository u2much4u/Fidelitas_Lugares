package com.fidelitas_lugares

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.fidelitas_lugares.databinding.ActivityMainBinding
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import javax.security.auth.login.LoginException

class MainActivity : AppCompatActivity() {

    //(Semana 1)(Java)(MainActivity.kt)
    //Definición de atributos generales
    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

       // (Semana 1)(Java)(MainActivity.kt)
       //Se establece el enlace con la vista xml mediante el objeto binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //(Semana 1)(Java)(MainActivity.kt)
       //Se inicializa Firebase y se asigna el objeto para autenticación
        FirebaseApp.initializeApp(this)
        auth = Firebase.auth

        //(Semana 1)(Java)(MainActivity.kt)
        //Recorte 006: se mapean los botones
        binding.btnregister.setOnClickListener { HacerRegistro() }
        binding.btnlogin.setOnClickListener { HacerLogin() }

        //Se borró para que funcionara
        //setContentView(R.layout.activity_main)
    }

    //(Semana 1)(Java)(MainActivity.kt)
    private fun HacerLogin() {
        val email = binding.txtcorreo.text.toString()
        val clave = binding.txtcontraseA.text.toString()

        //Se usa la función para crear un usuario por medio de correo y contraseña
        auth.signInWithEmailAndPassword(email,clave)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val user = auth.currentUser
                    actualiza(user)
                } else {
                    Toast.makeText(baseContext,
                        getString(R.string.msg_fallo_login),
                        Toast.LENGTH_SHORT).show()
                    actualiza(null)
                }
            }
    }
    //(Semana 1)(Java)(MainActivity.kt)
    private fun HacerRegistro() {
        val email = binding.txtcorreo.text.toString()
        val clave = binding.txtcontraseA.text.toString()

        //Se usa la función para crear un usuario por medio de correo y contraseña
        auth.createUserWithEmailAndPassword(email,clave)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val user = auth.currentUser
                    actualiza(user)
                } else {
                    Toast.makeText(baseContext,
                        getString(R.string.msg_fallo_registro),
                        Toast.LENGTH_SHORT).show()
                    actualiza(null)
                }
            }
    }
    //(Semana 1)(Java)(MainActivity.kt)
    private fun actualiza(user: FirebaseUser?) {
        if (user!=null) {
            //SE MUEVE A LA PANTALLA PRINCIPAL
            val intent = Intent(this,Principal::class.java)
            startActivity(intent)
        }
    }
}