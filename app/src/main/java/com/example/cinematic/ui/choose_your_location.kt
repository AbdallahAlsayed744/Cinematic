package com.example.cinematic.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.cinematic.R

class choose_your_location : AppCompatActivity() {
    lateinit var set_location:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_your_location)
        set_location=findViewById(R.id.btn_choose_your_location)
        set_location.setOnClickListener {
            startActivity(Intent(this,MapsActivity::class.java))
        }
    }
}