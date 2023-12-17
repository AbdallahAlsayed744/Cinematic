package com.example.cinematic.Fragments

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cinematic.R
import com.example.cinematic.pojo.info_details
import com.example.cinematic.ui.Book_Ticket
import com.example.cinematic.ui.adapter_of_infodetails

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Details_Fragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class Details_Fragment : Fragment() {
    lateinit var tv_des:TextView
    lateinit var tv_dir:TextView
    lateinit var arr:ArrayList<info_details>
    lateinit var adapter: adapter_of_infodetails
    lateinit var rv:RecyclerView
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
        val sh: SharedPreferences =requireActivity().getSharedPreferences("zop", AppCompatActivity.MODE_PRIVATE)
        val View= inflater.inflate(R.layout.fragment_details_, container, false)
        val x=sh.getString("description","zoooop")
        val y=sh.getString("director","wdwd")
        val actor_img=sh.getString("actor_img2","Dwd")
        val actor_name=sh.getString("actor_name2","cev")
        val actor_img2=sh.getString("actor_img3","Dwd")
        val actor_name2=sh.getString("actor_name3","cev")
        val actor_img3=sh.getString("actor_img4","Dwd")
        val actor_name3=sh.getString("actor_name4","cev")
        val actor_img4=sh.getString("actor_img5","Dwd")
        val actor_name4=sh.getString("actor_name5","cev")
        val film_name=sh.getString("film_name","fdefef")


        val book_ticket=View.findViewById<Button>(R.id.btn_details_bookticket)
        book_ticket.setOnClickListener {
            val intent=Intent(requireContext(),Book_Ticket::class.java)
            intent.putExtra("film",film_name)
            startActivity(intent)
        }


        tv_des=View.findViewById(R.id.description_tv)
        tv_dir=View.findViewById(R.id.director_tv)
        tv_des.text=x
        tv_dir.text=y
        arr=ArrayList()
        arr.add(info_details(actor_img,actor_name,actor_img2,actor_name2,actor_img3,actor_name3,actor_img4,actor_name4))
        adapter=adapter_of_infodetails(arr)
        rv=View.findViewById(R.id.rv_details)
        rv.setHasFixedSize(true)
        rv.layoutManager=GridLayoutManager(requireContext(),1)
        rv.adapter=adapter




        return View
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Details_Fragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Details_Fragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}