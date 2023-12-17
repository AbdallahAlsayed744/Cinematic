package com.example.cinematic.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo
import com.example.cinematic.R
import javax.net.ssl.HandshakeCompletedListener

class Animation_activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animation)
        YoYo.with(Techniques.FadeInUp).duration(700).repeat(5).playOn(findViewById(R.id.animation_logo))
        Handler().postDelayed(Runnable {
            kotlin.run {
                startActivity(Intent(this,Login::class.java))
            }
        },4000)

    }
}