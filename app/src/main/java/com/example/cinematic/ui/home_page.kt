package com.example.cinematic.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.cinematic.Fragments.CinemaFragment
import com.example.cinematic.Fragments.HomeFragment
import com.example.cinematic.Fragments.ProfileFragment
import com.example.cinematic.Fragments.TicketsFragment
import com.example.cinematic.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class home_page : AppCompatActivity() {
    lateinit var bot_nav: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)
        bot_nav = findViewById(R.id.Bottom_nav)
        creat_frag(HomeFragment())
        bot_nav.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home-> {creat_frag(HomeFragment())

                    return@setOnNavigationItemSelectedListener true


                }
                R.id.ciema->{
                    creat_frag(CinemaFragment())
                    return@setOnNavigationItemSelectedListener true

                }
                R.id.tickets->{
                    creat_frag(TicketsFragment())
                    return@setOnNavigationItemSelectedListener true

                }
                R.id.profile->{
                    creat_frag(ProfileFragment())
                    return@setOnNavigationItemSelectedListener true

                }
                else->false



            }
        }
    }
    fun creat_frag(frag:Fragment){
        val fg:FragmentManager=supportFragmentManager
        val ft:FragmentTransaction=fg.beginTransaction()
        ft.replace(R.id.frame,frag)
        ft.addToBackStack("")
        ft.commit()

    }
}