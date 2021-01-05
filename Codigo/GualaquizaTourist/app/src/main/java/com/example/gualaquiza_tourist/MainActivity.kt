package com.example.gualaquiza_tourist

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.FirebaseDatabase


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val boton : Button = findViewById(R.id.btnregistrar)
        boton.setOnClickListener {
            val miIntent = Intent(this, Registro::class.java)
            startActivity(miIntent)
        }

        }
    }

