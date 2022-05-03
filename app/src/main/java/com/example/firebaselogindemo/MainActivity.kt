package com.example.firebaselogindemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class MainActivity : AppCompatActivity() {
    lateinit var autentication:FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        autentication = FirebaseAuth.getInstance()
    }

    override fun onStart() {
        super.onStart()
        val user:FirebaseUser? = autentication.currentUser
        if(user==null){
            //manda login

        }
        else{
            //avanza a la pantalla principal
        }
    }

    fun login(){
        val correo: String = findViewById<EditText>(R.id.etUsuario).text.toString()
        val clave: String = findViewById<EditText>(R.id.etClave).text.toString()
        autentication.signInWithEmailAndPassword(correo,clave).addOnCompleteListener{
            if(it.isSuccessful){
                mensaje("Usuario correcto")

            }
            else{
                mensaje("usuario incorrecto")
            }
        }
    }

    fun revisa(view: View){
        login()
    }
    fun mensaje(mensaje:String){
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show()
    }
}