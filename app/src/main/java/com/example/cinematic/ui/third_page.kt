package com.example.cinematic.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.cinematic.R

class third_page : AppCompatActivity() {
    lateinit var get_start:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third_page)
        get_start=findViewById(R.id.thirdpage_button_getstart)
        get_start.setOnClickListener(View.OnClickListener {
            val intent=Intent(this,Animation_activity::class.java)
            startActivity(intent)
        })
    }
}