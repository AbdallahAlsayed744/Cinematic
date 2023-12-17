package com.example.cinematic.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.cinematic.R
import com.example.cinematic.pojo.cinema_info
import com.squareup.picasso.Picasso

class adapter_cinema(val arr:ArrayList<cinema_info>):RecyclerView.Adapter<adapter_cinema.vh>() {
    class vh(Itemview: View):ViewHolder(Itemview){
        val cinema_img:ImageView=Itemview.findViewById(R.id.cinema_imageview)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): vh {
        val View=LayoutInflater.from(parent.context).inflate(R.layout.cinema_design,null)
        return vh(View)
    }

    override fun getItemCount(): Int {
        return arr.size
    }

    override fun onBindViewHolder(holder: vh, position: Int) {
       val ar=arr[position]
        Picasso.get().load(ar.cinema_img).into(holder.cinema_img)
    }
}