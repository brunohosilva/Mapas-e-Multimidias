package com.example.mapasmultimidias

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.widget.MediaController
import android.view.View
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_video_media_player.*

class VideoMediaPlayer : AppCompatActivity() {

    private var uri: Uri? = null
    private var isContinuosly = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_media_player)

        // variavel que recebe os dados de controles de media
        val mediaController = MediaController(this)

        // indicando qual compoenente ira receber os controles
        mediaController.setAnchorView(vv)

        val uriPath = "https://archive.org/download/WildlifeSampleVideo/Wildlife.mp4"

        uri = Uri.parse(uriPath)

        // listener que observa quando vídeo completa
        vv!!.setOnCompletionListener {
            if (isContinuosly) {
                vv!!.start()
            }
        }


        // botao pausar
        btn_stop!!.setOnClickListener { vv!!.pause() }
        //botao de play
        btn_play.setOnClickListener { vv!!.start() }
        // botão que pausa o loop do vídeo
        btn_upload!!.setOnClickListener {
            isContinuosly = false
            progress!!.visibility = View.VISIBLE
            vv!!.setMediaController(mediaController)
            vv!!.setVideoURI(uri)
            vv!!.requestFocus()
            vv!!.start()
        }

        // botao quee reinicia o video
        btn_continuar!!.setOnClickListener {
            isContinuosly = true
            progress!!.visibility = View.VISIBLE
            vv!!.setMediaController(mediaController)
            vv!!.setVideoURI(uri)
            vv!!.requestFocus()
            vv!!.start()
        }

        // listener que disparar um evento quando o vídeo está pronto
        vv!!.setOnPreparedListener { progress!!.visibility = View.VISIBLE }

    }
}