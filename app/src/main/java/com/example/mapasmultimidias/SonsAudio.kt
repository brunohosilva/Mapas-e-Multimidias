package com.example.mapasmultimidias

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class SonsAudio : AppCompatActivity() {

    // Declaração das variaveis que irão receber a propriedade de media
    var cow: MediaPlayer? = null
    var dog: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sons_audio)

        // declarando os arquivos de áudio
        cow = MediaPlayer.create(this, R.raw.cow)
        dog = MediaPlayer.create(this, R.raw.dog)
    }

    // inicia a chamada o som
    fun soundCow(view: View){
        cow!!.start()
    }

    // inicia a chamada o som
    fun soundDog(view: View){
        dog!!.start()
    }
}