package com.example.cinematic.ui

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.Spannable
import android.text.SpannableString
import android.text.TextWatcher
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

class Signup : AppCompatActivity() {
    lateinit var tv:TextView
    lateinit var sign_up:Button
    lateinit var full_name:TextInputLayout
    lateinit var e_mail:TextInputLayout
    lateinit var password:TextInputLayout
    lateinit var confirm_password:TextInputLayout
    lateinit var auth:FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        tv=findViewById(R.id.signup_tv_signin)
        sign_up=findViewById(R.id.signup_button_signup)
        full_name=findViewById(R.id.signup_yourname)
        e_mail=findViewById(R.id.signup_youremail)
        password=findViewById(R.id.signup_yourpassword)
        confirm_password=findViewById(R.id.signup_yourconfirmpassword)
        auth=FirebaseAuth.getInstance()
        color_mytext2()

        tv.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this,Login::class.java))
        })
        sign_up.setOnClickListener(View.OnClickListener {
            if (full_name.editText?.text.toString().isEmpty())
            {
                Toast.makeText(this, "Invalid Value!", Toast.LENGTH_LONG).show()
            }
            else if(e_mail.editText?.text.toString().isEmpty()){
                Toast.makeText(this, "Invalid Value!", Toast.LENGTH_LONG).show()
            }
            else if(password.editText?.text.toString().isEmpty())
            {
                Toast.makeText(this, "Invalid Value!", Toast.LENGTH_LONG).show()

            }
            else if(confirm_password.editText?.text.toString().isEmpty()){
                Toast.makeText(this, "Invalid Value!", Toast.LENGTH_LONG).show()

            }
            else{
                auth.createUserWithEmailAndPassword(e_mail.editText?.text.toString(),password.editText?.text.toString()).addOnCompleteListener {
                    if(it.isSuccessful){
                        Toast.makeText(this, "Successful Registration", Toast.LENGTH_SHORT).show()
                        startActivity(Intent(this,Login::class.java))
                        val root:DatabaseReference=FirebaseDatabase.getInstance().getReference()

                        val dataMap = HashMap<String, Any>()
                        dataMap["user name"] = full_name.editText?.text.toString()
                        dataMap["email"] = e_mail.editText?.text.toString()
                        dataMap["password"] = password.editText?.text.toString()

                        val currentuser:FirebaseUser?=FirebaseAuth.getInstance().currentUser

                        if (currentuser != null) {
                            root.child("signup_info").child(currentuser.uid).setValue(dataMap).addOnCompleteListener {
                                if(it.isSuccessful){
                                    Toast.makeText(this, "Save", Toast.LENGTH_LONG).show()
                                }
                                else{
                                    Toast.makeText(this, "not save", Toast.LENGTH_LONG).show()
                                }
                            }
                        }



                    }else{
                        Toast.makeText(this, it.exception.toString(), Toast.LENGTH_LONG).show()

                    }
                }


            }


        })

        confirm_password.editText?.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (password.editText!!.text.toString() != confirm_password.editText!!.text.toString())

                {
                    confirm_password.error = "password isn't identical"
                } else {
                    confirm_password.error = null
                }
            }

            override fun afterTextChanged(s: Editable) {}
        })






    }

    private fun color_mytext2() {
        val wordtoSpan: Spannable = SpannableString("Already have an account? Sign in")
        wordtoSpan.setSpan(
            ForegroundColorSpan(Color.rgb(113, 93, 203)),
            25,
            32,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        tv.text = wordtoSpan
    }
}