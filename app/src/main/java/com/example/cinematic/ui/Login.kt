package com.example.cinematic.ui

import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.cinematic.R
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase


class Login : AppCompatActivity() {
    lateinit var tv: TextView
    val CurrentUser: FirebaseUser? =FirebaseAuth.getInstance().currentUser
    val root: DatabaseReference = FirebaseDatabase.getInstance().getReference()
    lateinit var login: Button
    lateinit var auth: FirebaseAuth
    lateinit var ed_name: TextInputLayout
    lateinit var ed_password: TextInputLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        tv = findViewById(R.id.textView12)
        login = findViewById(R.id.btn_choose_your_location)
        ed_name = findViewById(R.id.passwordTextInputLayout2)
        ed_password = findViewById(R.id.passwordTextInputLayout)
        color_mytext()
        auth = FirebaseAuth.getInstance()


//        if (CurrentUser != null) {
//            startActivity(Intent(this,home_page::class.java))
//        } else {
//            startActivity(Intent(this,login::class.java))
//        }
        login.setOnClickListener {
            if (ed_name.editText?.text.toString().isEmpty()) {

                Toast.makeText(this, "Invalid value! ", Toast.LENGTH_LONG).show()
            } else if (ed_password.editText!!.text.toString().isEmpty()) {
                Toast.makeText(this, "Invalid value! ", Toast.LENGTH_LONG).show()

            } else {
                auth.signInWithEmailAndPassword(
                    ed_name.editText?.text.toString(),
                    ed_password.editText?.text.toString()
                ).addOnCompleteListener {
                    if (it.isSuccessful) {
                        Toast.makeText(this, "Successfully Login", Toast.LENGTH_SHORT).show()
                        startActivity(Intent(this,choose_your_location::class.java))
                    } else {
                        Toast.makeText(this,"Fail Login", Toast.LENGTH_SHORT).show()
                    }
                }
            }


        }
        tv.setOnClickListener(View.OnClickListener {
            val intent=Intent(this,Signup::class.java)
            startActivity(intent)
        })
        val sh:SharedPreferences=getSharedPreferences("name", MODE_PRIVATE)
        val edit:SharedPreferences.Editor=sh.edit()
        val name=ed_name.editText?.text.toString()
        edit.putString("my_name",name)
        edit.commit()
    }
    private fun color_mytext() {
        val wordtoSpan: Spannable = SpannableString("Don't have account? Sign up")
        wordtoSpan.setSpan(
            ForegroundColorSpan(Color.rgb(113, 93, 203)),
            20,
            27,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        tv.text = wordtoSpan
    }

    override fun onStart() {
        super.onStart()
        if (CurrentUser != null) {
            startActivity(Intent(this, home_page::class.java))

        }
    }
}