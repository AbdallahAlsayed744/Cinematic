package com.example.cinematic.Fragments

import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.isVisible
import com.example.cinematic.R
import com.squareup.picasso.Picasso

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Payment_Fragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class Payment_Fragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v= inflater.inflate(R.layout.fragment_payment_, container, false)
        val film_image=v.findViewById<ImageView>(R.id.frag_payment_FilmImage)
        val film_rate=v.findViewById<TextView>(R.id.frag_payment_FilmRate)
        val film_nmae=v.findViewById<TextView>(R.id.frag_payment_FilmName)
        val rdb=v.findViewById<RadioButton>(R.id.radioButton_creditcard)
        val rdb22=v.findViewById<RadioButton>(R.id.radioButton)
        val chapter=v.findViewById<TextView>(R.id.frag_payment_FilmPart)
        val card=v.findViewById<CardView>(R.id.frag_payment_cardview)
        val type=v.findViewById<TextView>(R.id.frag_payment_FilmType)
        val sh2:SharedPreferences=requireActivity().getSharedPreferences("frag_payment",AppCompatActivity.MODE_PRIVATE)
        val image=sh2.getString("image","sdsd")
        Picasso.get().load(image).into(film_image)
        val rate=sh2.getString("rate","wdwd")
        film_rate.text=rate
        val name=sh2.getString("film_name","xwxx")
        film_nmae.text=name
        val film_chapter=sh2.getString("film_chapter","sdsds")
        chapter.text=film_chapter
        val film_type=sh2.getString("film_type","csc")
        type.text=film_type
        rdb.setOnClickListener {
            card.visibility=View.VISIBLE


        }
        rdb22.setOnClickListener {
            card.visibility=View.INVISIBLE
        }











        return v
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Payment_Fragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Payment_Fragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}