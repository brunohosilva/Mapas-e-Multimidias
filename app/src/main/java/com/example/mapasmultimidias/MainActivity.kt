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

        webview_use.setOnClickListener(){
            acessarwebView()
        }

        sons_audio.setOnClickListener(){
            acessarAudio()
        }
    }

    fun acessarFoto() {
        val intent = Intent(this, RecuperaFoto::class.java)
        startActivity(intent)
    }

    fun acessarwebView() {
        val intent = Intent(this, Webview::class.java)
        startActivity(intent)
    }

    fun acessarAudio() {
        val intent = Intent(this, SonsAudio::class.java)
        startActivity(intent)
    }
}