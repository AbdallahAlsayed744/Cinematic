package com.example.cinematic.ui

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.cinematic.R
import com.example.cinematic.pojo.image
import com.squareup.picasso.Picasso

class adapter2_of_image(val arr:ArrayList<image>):RecyclerView.Adapter<adapter2_of_image.vh>() {
    class vh(itemView: View): ViewHolder(itemView){
        val img:ImageView=itemView.findViewById(R.id.image_of_adapter2)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): vh {
        val View=LayoutInflater.from(parent.context).inflate(R.layout.image_design2,null)
        return vh(View)
    }

    override fun getItemCount(): Int {
        return arr.size
    }

    override fun onBindViewHolder(holder: vh, position: Int) {

        val img2=arr[position]
        Picasso.get().load(img2.image).into(holder.img)
        holder.img.setOnClickListener {
            val intent=Intent(holder.img.context,Show::class.java)
            intent.putExtra("film_image",img2.image)
            intent.putExtra("film_rate",img2.rate)
            intent.putExtra("film_chapter",img2.chapter)
            intent.putExtra("film_type",img2.film_type)
            intent.putExtra("video",img2.video)
            intent.putExtra("desc",img2.desc)
            intent.putExtra("dir",img2.dir)
            intent.putExtra("actor_img",img2.acctor_img)
            intent.putExtra("actor_name",img2.acctor_name)
            intent.putExtra("actor_img2",img2.acctor_img2)
            intent.putExtra("actor_name2",img2.acctor_name2)
            intent.putExtra("actor_img3",img2.acctor_img3)
            intent.putExtra("actor_name3",img2.acctor_name3)
            intent.putExtra("actor_img4",img2.acctor_img4)
            intent.putExtra("actor_name4",img2.acctor_name4)
            intent.putExtra("film_name",img2.film_name)
            holder.img.context.startActivity(intent)



        }

    }
}