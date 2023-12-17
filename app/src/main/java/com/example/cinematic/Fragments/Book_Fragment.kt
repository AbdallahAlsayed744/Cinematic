package com.example.cinematic.Fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.content.ContextCompat
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cinematic.R
import com.example.cinematic.pojo.date_time
import com.example.cinematic.ui.date_time_adapter

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Book_Fragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class Book_Fragment : Fragment() {
    var check:Boolean=true
    var check2:Boolean=true
    var check3:Boolean=true
    var check4:Boolean=true
    var check5:Boolean=true
    var check6:Boolean=true
    var check7:Boolean=true
    var check8:Boolean=true
    var check9:Boolean=true
    var check10:Boolean=true
    lateinit var arr:ArrayList<date_time>
    lateinit var adapter:date_time_adapter
    lateinit var RV:RecyclerView
    lateinit var v1:View
    lateinit var v2:View
    lateinit var v4:View
    lateinit var v7:View
    lateinit var v9:View
    lateinit var v10:View
    lateinit var v13:View
    lateinit var v14:View
    lateinit var v15:View
    lateinit var v16:View


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
        val View=inflater.inflate(R.layout.fragment_book_, container, false)
        RV=View.findViewById(R.id.time_rv)
        arr= ArrayList()
        arr.add(date_time("Fri","1","Mai","9:00AM"))
        arr.add(date_time("Sat","2","Mai","12:00PM"))
        arr.add(date_time("Sun","3","Mai","3:00PM"))
        arr.add(date_time("Mon","4","Mai","6:00PM"))
        arr.add(date_time("Tue","5","Mai","9:00PM"))
        adapter= date_time_adapter(arr)
        RV.setHasFixedSize(true)
        RV.layoutManager=LinearLayoutManager(requireContext(),RecyclerView.HORIZONTAL,false)
        RV.adapter=adapter
        v1=View.findViewById(R.id.view1)
        v2=View.findViewById(R.id.view2)
        v4=View.findViewById(R.id.view4)
        v7=View.findViewById(R.id.view7)
        v9=View.findViewById(R.id.view9)
        v10=View.findViewById(R.id.view10)
        v13=View.findViewById(R.id.view14)
        v14=View.findViewById(R.id.view15)
        v15=View.findViewById(R.id.view16)
        v16=View.findViewById(R.id.view17)

        v1.setOnClickListener {
            if (check) {
                v1.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.seat_color))
                check=false
            }
            else if(check==false){
                v1.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.baseline_airline_seat_recline_normal_24))
                check=true


            }

        }
        v2.setOnClickListener {
            if (check2) {
                v2.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.seat_color))
                check2=false
            }
            else if(check2==false){
                v2.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.baseline_airline_seat_recline_normal_24))
                check2=true


            }
        }
        v4.setOnClickListener {
            if (check3) {
                v4.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.seat_color))
                check3=false
            }
            else if(check3==false){
                v4.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.baseline_airline_seat_recline_normal_24))
                check3=true


            }
        }
        v7.setOnClickListener {
            if (check4) {
                v7.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.seat_color))
                check4=false
            }
            else if(check4==false){
                v7.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.baseline_airline_seat_recline_normal_24))
                check4=true


            }
        }
        v9.setOnClickListener {
            if (check5) {
                v9.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.seat_color))
                check5=false
            }
            else if(check5==false){
                v9.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.baseline_airline_seat_recline_normal_24))
                check5=true


            }        }
        v10.setOnClickListener {
            if (check6) {
                v10.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.seat_color))
                check6=false
            }
            else if(check6==false){
                v10.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.baseline_airline_seat_recline_normal_24))
                check6=true


            }        }
        v13.setOnClickListener {
            if (check7) {
                v13.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.seat_color))
                check7=false
            }
            else if(check7==false){
                v13.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.baseline_airline_seat_recline_normal_24))
                check7=true


            }
        }
        v14.setOnClickListener {
            if (check8) {
                v14.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.seat_color))
                check8=false
            }
            else if(check8==false){
                v14.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.baseline_airline_seat_recline_normal_24))
                check8=true


            }
        }
        v15.setOnClickListener {
            if (check9) {
                v15.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.seat_color))
                check9=false
            }
            else if(check9==false){
                v15.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.baseline_airline_seat_recline_normal_24))
                check9=true


            }
        }
        v16.setOnClickListener {
            if (check10) {
                v16.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.seat_color))
                check10=false
            }
            else if(check10==false){
                v16.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.baseline_airline_seat_recline_normal_24))
                check10=true


            }        }
        return View
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Book_Fragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Book_Fragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}