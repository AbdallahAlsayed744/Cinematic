package com.example.cinematic.Fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cinematic.R
import com.example.cinematic.pojo.image
import com.example.cinematic.ui.adapter2_of_image
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
 * Use the [PopularFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PopularFragment : Fragment() {
    lateinit var arr:ArrayList<image>
    lateinit var adapter:adapter2_of_image
    lateinit var rv:RecyclerView
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

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v:View= inflater.inflate(R.layout.fragment_popular, container, false)
        arr= ArrayList()
        rv=v.findViewById(R.id.frag_popular_rv)
        adapter= adapter2_of_image(arr)
        rv.setHasFixedSize(true)
        rv.layoutManager=GridLayoutManager(requireContext(),2)
        rv.adapter=adapter
        root.child("films").addValueEventListener(object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                arr.clear()
               for (imagesnapshot in snapshot.children){
                   val myimage=imagesnapshot.child("film").value.toString()
                   val video=imagesnapshot.child("video").value.toString()
                   val descr=imagesnapshot.child("desc").value.toString()
                   val dire=imagesnapshot.child("dir").value.toString()
                   val act_img=imagesnapshot.child("actor_img").value.toString()
                   val act_name=imagesnapshot.child("actor_name").value.toString()
                   val act_img2=imagesnapshot.child("actor_img2").value.toString()
                   val act_name2=imagesnapshot.child("actor_name2").value.toString()
                   val act_img3=imagesnapshot.child("actor_img3").value.toString()
                   val act_name3=imagesnapshot.child("actor_name3").value.toString()
                   val act_img4=imagesnapshot.child("actor_img4").value.toString()
                   val act_name4=imagesnapshot.child("actor_name4").value.toString()
                   val film_name=imagesnapshot.child("film_name").value.toString()
                   val rate=imagesnapshot.child("rate").value.toString()
                   val chapter=imagesnapshot.child("chapter").value.toString()
                   val type=imagesnapshot.child("film_type").value.toString()


                   arr.add(image(myimage,video,descr,dire,act_img,act_name,act_img2,act_name2,act_img3,act_name3,act_img4,act_name4,film_name,rate,chapter,type))

               }
                adapter.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {

            }

        })


        return v
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment PopularFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            PopularFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}