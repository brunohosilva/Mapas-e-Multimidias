package com.example.mapasmultimidias

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recuperando_img.setOnClickListener(){
            acessarFoto()
        }
    }

    fun acessarFoto() {
        val intent = Intent(this, RecuperaFoto::class.java)
        startActivity(intent)
    }
}