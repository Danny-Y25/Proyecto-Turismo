package com.example.gualaquiza_tourist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import com.google.firebase.auth.FirebaseAuth

class Registro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)
        login()
    }
    private fun login() {
        title = "Autentificacion"
        val register : Button = findViewById(R.id.btnregis)
        val contra =  findViewById<EditText>(R.id.editTextTextPersonName2)
        val mail = findViewById<EditText>(R.id.editTextTextPersonName7)

        register.setOnClickListener {
            if (mail.text.isNotEmpty() && contra.text.isNotEmpty()) {
                FirebaseAuth.getInstance().createUserWithEmailAndPassword(mail.text.toString(), contra.text.toString()).addOnCompleteListener {
                    if (it.isSuccessful){
                        register.setOnClickListener{
                            val mostrar = Intent(this,MainActivity::class.java)
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
        val dialog: AlertDialog =builder.create()
        dialog.show()

    }
}