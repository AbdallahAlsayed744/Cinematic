package com.example.cinematic.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.cinematic.R
import com.example.cinematic.pojo.image
import com.squareup.picasso.Picasso

class image_adapter(val arr:ArrayList<image>):RecyclerView.Adapter<image_adapter.vh>() {
    class vh(itemView: View):ViewHolder(itemView){
        val imge:ImageView=itemView.findViewById(R.id.design_my_image)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): vh {
       val view=LayoutInflater.from(parent.context).inflate(R.layout.design_image,null)
        return vh(view)
    }

    override fun getItemCount(): Int {
        return arr.size
    }

    override fun onBindViewHolder(holder: vh, position: Int) {
        val img3=arr[position]
        Picasso.get().load(img3.image).into(holder.imge)

    }
}