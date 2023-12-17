package com.example.cinematic.ui

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.TextView
import androidx.appcompat.view.menu.MenuBuilder
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView
import androidx.navigation.findNavController
import androidx.viewpager2.widget.ViewPager2

import com.example.cinematic.Fragments.Book_Fragment
import com.example.cinematic.Fragments.Confirmation_Fragment
import com.example.cinematic.Fragments.Payment_Fragment
import com.example.cinematic.R
import com.mo_stepper.mohorizontalstepper.MoHorizontalStepper


class Book_Ticket : AppCompatActivity() {
    lateinit var vp:ViewPager2
//    lateinit var stepperIndicator: StepperIndicator
    lateinit var txt:TextView




    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_ticket)
        txt=findViewById(R.id.book_ticket_tv_filmname)
        val film_name=intent.getStringExtra("film")
        txt.text=film_name
        val stepper = findViewById<MoHorizontalStepper>(R.id.stepper)
        val navHostFragment = findViewById<FragmentContainerView>(R.id.frame_stepper)
        val myMenu =  MenuBuilder(this)
        menuInflater.inflate(R.menu.stepper_menue, myMenu)


        stepper.apply {
            setStepperMode(MoHorizontalStepper.MoStepperMode.SELECT_PREVIOUS_AND_CURRENT)
            setNumberOfSteps(3)
            setNavigationMenu(myMenu)


        }
        stepper.stepClickListener={stepIndex ->
            val fragmentId = stepper.getFragmentByIndex(stepIndex-1)
            fragmentId?.let { destination ->
                val navController = navHostFragment.findNavController()
                navController.navigate(destination, null, null, null)
                stepper.setCurrentStep(stepIndex)

            }}

    }
}
