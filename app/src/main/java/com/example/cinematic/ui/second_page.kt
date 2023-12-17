package com.example.cinematic.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.cinematic.R

class second_page : AppCompatActivity() {
    lateinit var btn_skip:Button
    lateinit var skip_tv:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_page)
        btn_skip=findViewById(R.id.Secondpage_button_next2)
        skip_tv=findViewById(R.id.Secondpage_tv_skip)
        btn_skip.setOnClickListener(View.OnClickListener {
            val inte=Intent(this,third_page::class.java)
            startActivity(inte)
        })
        skip_tv.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this,Login::class.java))
        })
    }
}