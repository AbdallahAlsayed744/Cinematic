package com.example.cinematic.Fragments

import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import com.example.cinematic.R
import com.example.cinematic.ui.dialoge_fragment
import com.squareup.picasso.Picasso

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Confirmation_Fragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class Confirmation_Fragment : Fragment() {
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

       val v= inflater.inflate(R.layout.fragment_confirmation_, container, false)
        val film_image=v.findViewById<ImageView>(R.id.frag_confirmation_film_img)
        val confirm=v.findViewById<Button>(R.id.frag_confirmation_btn_confirm)
        val sh:SharedPreferences=requireActivity().getSharedPreferences("frag_payment",MODE_PRIVATE)
        val image=sh.getString("image","dvsdvsv")
        Picasso.get().load(image).into(film_image)
        confirm.setOnClickListener {
            val res=dialoge_fragment()
            res.show(requireActivity().supportFragmentManager,"ddkod")


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
         * @return A new instance of fragment Confirmation_Fragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Confirmation_Fragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}