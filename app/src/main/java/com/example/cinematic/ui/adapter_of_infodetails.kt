package com.example.cinematic.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.cinematic.R
import com.example.cinematic.pojo.info_details
import com.squareup.picasso.Picasso

class adapter_of_infodetails(val arr:ArrayList<info_details>):RecyclerView.Adapter<adapter_of_infodetails.vh>() {
    class vh(itemView: View):ViewHolder(itemView){
        var img:ImageView=itemView.findViewById(R.id.img3)
        var text:TextView=itemView.findViewById(R.id.textView21)
        var img2:ImageView=itemView.findViewById(R.id.img2)
        var text2:TextView=itemView.findViewById(R.id.name2)
        var img3:ImageView=itemView.findViewById(R.id.img33)
        var text3:TextView=itemView.findViewById(R.id.name3)
        var img4:ImageView=itemView.findViewById(R.id.img4)
        var text4:TextView=itemView.findViewById(R.id.name4)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): vh {
        val View=LayoutInflater.from(parent.context).inflate(R.layout.design_details,null)

        return vh(View)

    }

    override fun getItemCount(): Int {
       return arr.size
    }

    override fun onBindViewHolder(holder: vh, position: Int) {
        val ar=arr[position]
        Picasso.get().load(ar.image).into(holder.img)
        holder.text.text=ar.text_image
        Picasso.get().load(ar.image2).into(holder.img2)
        holder.text2.text=ar.text_image2
        Picasso.get().load(ar.image3).into(holder.img3)
        holder.text3.text=ar.text_image3
        Picasso.get().load(ar.image4).into(holder.img4)
        holder.text4.text=ar.text_image4

    }
}