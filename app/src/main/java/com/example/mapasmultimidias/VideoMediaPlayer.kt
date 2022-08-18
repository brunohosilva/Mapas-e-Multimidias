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

        val mediaController = MediaController(this)
        mediaController.setAnchorView(vv)

        val uriPath = "https://archive.org/download/WildlifeSampleVideo/Wildlife.mp4"

        uri = Uri.parse(uriPath)

        vv!!.setOnCompletionListener {
            if (isContinuosly) {
                vv!!.start()
            }
        }

        btn_stop!!.setOnClickListener { vv!!.pause() }
        btn_play.setOnClickListener { vv!!.start() }

        btn_upload!!.setOnClickListener {
            isContinuosly = false
            progress!!.visibility = View.VISIBLE
            vv!!.setMediaController(mediaController)
            vv!!.setVideoURI(uri)
            vv!!.requestFocus()
            vv!!.start()
        }

        btn_continuar!!.setOnClickListener {
            isContinuosly = true
            progress!!.visibility = View.VISIBLE
            vv!!.setMediaController(mediaController)
            vv!!.setVideoURI(uri)
            vv!!.requestFocus()
            vv!!.start()
        }

        vv!!.setOnPreparedListener { progress!!.visibility = View.VISIBLE }

    }
}