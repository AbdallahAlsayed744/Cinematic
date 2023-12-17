package com.example.cinematic.Fragments

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cinematic.R
import com.example.cinematic.pojo.image
import com.example.cinematic.ui.image_adapter
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    lateinit var rv:RecyclerView
    lateinit var arr:ArrayList<image>
    lateinit var adapter:image_adapter
    lateinit var last:Button
    lateinit var up_comming:Button
    val root:DatabaseReference=FirebaseDatabase.getInstance().getReference()
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
        val view:View= inflater.inflate(R.layout.fragment_home, container, false)
        rv=view.findViewById(R.id.rv1)
        arr= ArrayList()
        adapter= image_adapter(arr)
        rv.layoutManager=LinearLayoutManager(requireContext(),RecyclerView.HORIZONTAL,false)
        rv.setHasFixedSize(true)
        rv.adapter=adapter
        root.child("images").addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                arr.clear()
                for (imagesnapshot in snapshot.children){
                    val image=imagesnapshot.child("img").value.toString()
                    arr.add(image(image,"","","","","","","","","","","","","","",""))

                }
                adapter.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {

            }

        })
        val fg:FragmentManager=requireActivity().supportFragmentManager
        val ft:FragmentTransaction=fg.beginTransaction()
        val frag=PopularFragment()
        ft.replace(R.id.fragmentContainerView,frag)
        ft.addToBackStack("")
        ft.commit()
        val popular =view.findViewById<Button>(R.id.button_popular)
        popular.setOnClickListener {
            popular.setTextColor(ContextCompat.getColorStateList(requireContext(),R.color.white))
            popular.setBackgroundResource(R.drawable.btn_shabe)
            last.setTextColor(ContextCompat.getColorStateList(requireContext(),R.color.zozoz))
            last.setBackgroundResource(R.drawable.btn)
            up_comming.setBackgroundResource(R.drawable.btn)
            up_comming.setTextColor(ContextCompat.getColorStateList(requireContext(),R.color.zozoz))

            val fg:FragmentManager=requireActivity().supportFragmentManager
            val ft:FragmentTransaction=fg.beginTransaction()
            val frag=PopularFragment()
            ft.replace(R.id.fragmentContainerView,frag)
            ft.addToBackStack("")
            ft.commit()
        }
        last=view.findViewById(R.id.button_latest)
        last.setOnClickListener {
            popular.setTextColor(ContextCompat.getColorStateList(requireContext(),R.color.zozoz))
            popular.setBackgroundResource(R.drawable.btn)
            up_comming.setBackgroundResource(R.drawable.btn)
            up_comming.setTextColor(ContextCompat.getColorStateList(requireContext(),R.color.zozoz))
            it.setBackgroundResource(R.drawable.btn_shabe)
            last.setTextColor(ContextCompat.getColorStateList(requireContext(),R.color.white))
            val fm:FragmentManager=requireActivity().supportFragmentManager
            val ft:FragmentTransaction=fm.beginTransaction()
            val frag=LastFragment()
            ft.replace(R.id.fragmentContainerView,frag)
            ft.addToBackStack("")
            ft.commit()

        }
        up_comming=view.findViewById(R.id.button_upcomming)
        up_comming.setOnClickListener {
            popular.setTextColor(ContextCompat.getColorStateList(requireContext(),R.color.zozoz))
            popular.setBackgroundResource(R.drawable.btn)
            last.setTextColor(ContextCompat.getColorStateList(requireContext(),R.color.zozoz))
            last.setBackgroundResource(R.drawable.btn)
            up_comming.setBackgroundResource(R.drawable.btn_shabe)
            up_comming.setTextColor(ContextCompat.getColorStateList(requireContext(),R.color.white))
            val fm:FragmentManager=requireActivity().supportFragmentManager
            val ft:FragmentTransaction=fm.beginTransaction()
            val frag=UpcomingFragment()
            ft.replace(R.id.fragmentContainerView,frag)
            ft.addToBackStack("")
            ft.commit()

        }


        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}