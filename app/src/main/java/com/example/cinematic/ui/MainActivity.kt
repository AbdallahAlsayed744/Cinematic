package com.example.cinematic.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.cinematic.R

class MainActivity : AppCompatActivity() {
    lateinit var btn_next:Button
    lateinit var tv_skip:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_next=findViewById(R.id.firstpage_button_next)
        tv_skip=findViewById(R.id.firstpage_tv_skip)
       btn_next.setOnClickListener(View.OnClickListener {
           val my_in=Intent(this,second_page::class.java)
           startActivity(my_in)

       })
       tv_skip.setOnClickListener(View.OnClickListener {
           startActivity(Intent(this,Login::class.java))
       })

    }
}