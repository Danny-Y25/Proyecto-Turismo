package com.example.gualaquiza_tourist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Menu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val resta : Button = findViewById(R.id.btnres)
        resta.setOnClickListener {
            val restaurante = Intent(this, Restaurantes::class.java)
            startActivity(restaurante)
        }

        val luga : Button = findViewById(R.id.btnturis)
        luga.setOnClickListener {
            val lugares = Intent(this, Lugares::class.java)
            startActivity(lugares)
        }
        val hote : Button = findViewById(R.id.btnhote)
        hote.setOnClickListener {
            val hoteles = Intent(this, Hoteles::class.java)
            startActivity(hoteles)
        }
        val gastro : Button = findViewById(R.id.btngastr)
        gastro.setOnClickListener {
            val gastronomia = Intent(this, Gastronomia::class.java)
            startActivity(gastronomia)
        }

        val fau : Button = findViewById(R.id.btnfa)
        fau.setOnClickListener {
            val fauna = Intent(this, Fauna::class.java)
            startActivity(fauna)
        }
        val flo : Button = findViewById(R.id.btnflora)
        flo.setOnClickListener {
            val flora = Intent(this, Flora::class.java)
            startActivity(flora)
        }
    }
}