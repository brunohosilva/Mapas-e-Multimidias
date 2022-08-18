package com.example.mapasmultimidias

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_animation.*

class Animation : AppCompatActivity() {

    // Declarado array com os nomes de efeitos
    internal var animations = arrayOf(
        "Fade In",
        "Fade Out",
        "Zoom In",
        "Zoom Out",
        "Blink",
        "Rotate",
        "Move",
        "Slide Up",
        "Slide Down",
        "Bounce"
    )


    // declarado um array com os arquivos de efeito
    internal var animationIDs = intArrayOf(
        R.anim.fade_in,
        R.anim.fade_out,
        R.anim.zoom_in,
        R.anim.zoom_out,
        R.anim.blink,
        R.anim.rotate,
        R.anim.move,
        R.anim.slide_up,
        R.anim.slide_down,
        R.anim.bounce
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animation)

        // seta itens de animacoes na lista
        lv.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, animations)

        // click de cada evento de animacao
        lv.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            // transformar os XML em Animations
            val animation = AnimationUtils.loadAnimation(this, animationIDs[position])
            // executa a animação
            tv.startAnimation(animation)
        }
    }
}