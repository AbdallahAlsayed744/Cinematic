package com.example.cinematic.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.DialogFragment
import com.example.cinematic.Fragments.TicketsFragment
import com.example.cinematic.R
import java.util.zip.Inflater

class dialoge_fragment:DialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v:View=inflater.inflate(R.layout.dialoge_frament_design,container,false)
        val view_ticket=v.findViewById<Button>(R.id.frag_dialoge_btn_viewTicket)
        view_ticket.setOnClickListener {
            startActivity(Intent(requireContext(),home_page::class.java))
        }


        return v
    }
}