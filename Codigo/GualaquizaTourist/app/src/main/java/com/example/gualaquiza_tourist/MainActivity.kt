package com.example.gualaquiza_tourist

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.util.Log.*
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import org.w3c.dom.Text


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val boton : Button = findViewById(R.id.btnregistrar)
        boton.setOnClickListener {
            val miIntent = Intent(this, Registro::class.java)
            startActivity(miIntent)
        }
        //setup
        login();

        }
        private fun login() {
            title = "Autentificacion"
            val login : Button = findViewById(R.id.btnlogin)
            val contra =  findViewById<EditText>(R.id.editTextTextPassword)
            val mail = findViewById<EditText>(R.id.editTextTextPersonName)

            login.setOnClickListener {
                if (mail.text.isNotEmpty() && contra.text.isNotEmpty()) {
                    FirebaseAuth.getInstance().signInWithEmailAndPassword(mail.text.toString(), contra.text.toString()).addOnCompleteListener {
                        if (it.isSuccessful){
                            login.setOnClickListener{
                                val mostrar = Intent(this,Menu::class.java)
                                startActivity(mostrar)
                            }
                        }else{
                            alert()
                        }
                    }
                }
            }
        }
        private fun alert(){
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Error")
            builder.setMessage("Se ha producido un error autentificando al usuario")
            builder.setPositiveButton("Aceptar",null)
            val dialog: AlertDialog=builder.create()
            dialog.show()

        }
    }

