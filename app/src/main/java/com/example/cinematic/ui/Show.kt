package com.example.cinematic.ui

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.MediaController
import android.widget.TextView
import android.widget.Toast
import android.widget.VideoView
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.cinematic.Fragments.Details_Fragment
import com.example.cinematic.R
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class Show : AppCompatActivity() {
    lateinit var video2:VideoView
    val root:DatabaseReference=FirebaseDatabase.getInstance().getReference()
    lateinit var linear:View
    lateinit var heart:ImageView
    var cheakedd:Boolean=true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show)
        video2=findViewById(R.id.videoView)
        heart=findViewById(R.id.show_heart)
        linear=findViewById(R.id.my_linear)
        val video = intent.getStringExtra("video")
        val des=intent.getStringExtra("desc")
        val dir=intent.getStringExtra("dir")
        val actor_img=intent.getStringExtra("actor_img")
        val actor_name=intent.getStringExtra("actor_name")
        val actor_img2=intent.getStringExtra("actor_img2")
        val actor_name2=intent.getStringExtra("actor_name2")
        val actor_img3=intent.getStringExtra("actor_img3")
        val actor_name3=intent.getStringExtra("actor_name3")
        val actor_img4=intent.getStringExtra("actor_img4")
        val actor_name4=intent.getStringExtra("actor_name4")
        val film_name=intent.getStringExtra("film_name")
        val film_image=intent.getStringExtra("film_image")
        val film_rate=intent.getStringExtra("film_rate")
        val chapter=intent.getStringExtra("film_chapter")
        val type=intent.getStringExtra("film_type")

        val sh2:SharedPreferences=getSharedPreferences("frag_payment", MODE_PRIVATE)
        val edit2:SharedPreferences.Editor=sh2.edit()
        edit2.putString("image",film_image)
        edit2.putString("rate",film_rate)
        edit2.putString("film_name",film_name)
        edit2.putString("film_chapter",chapter)
        edit2.putString("film_type",type)
        edit2.commit()

        val sh3:SharedPreferences=getSharedPreferences("frag_tickets", MODE_PRIVATE)
        val edit3:SharedPreferences.Editor=sh3.edit()
        edit3.putString("image",film_image)
        edit3.commit()

        val sh:SharedPreferences=getSharedPreferences("zop", MODE_PRIVATE)
        val edit:SharedPreferences.Editor=sh.edit()
        edit.putString("description",des)
        edit.putString("director",dir)
        edit.putString("actor_img2",actor_img)
        edit.putString("actor_name2",actor_name)
        edit.putString("actor_img3",actor_img2)
        edit.putString("actor_name3",actor_name2)
        edit.putString("actor_img4",actor_img3)
        edit.putString("actor_name4",actor_name3)
        edit.putString("actor_img5",actor_img4)
        edit.putString("actor_name5",actor_name4)
        edit.putString("film_name",film_name)

        edit.commit()


        video2.setVideoPath(video)
       val mediaController = MediaController(this)
        mediaController.setMediaPlayer(video2)
        video2.setMediaController(mediaController)
        mediaController.setAnchorView(video2)
       video2.start()
       val fm:FragmentManager=supportFragmentManager
       val ft:FragmentTransaction=fm.beginTransaction()
        val frag=Details_Fragment()
       ft.replace(R.id.fragmentContainerView2,frag)
       ft.commit()


      heart.setOnClickListener {
          if(cheakedd){
              heart.setImageResource(R.drawable.baseline_favorite_24)
              cheakedd=false
              val snack=Snackbar.make(linear,"saved in your favorites",3000)
              snack.setAction("Open",View.OnClickListener {

              })
              snack.show()


          }
          else if(cheakedd==false){
              heart.setImageResource(R.drawable.favorite_40)
              cheakedd=true

          }

      }




    }
}