package com.example.cinematic.ui

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.cinematic.R
import com.example.cinematic.pojo.date_time
import com.google.firebase.database.collection.LLRBNode

class date_time_adapter(val arr:ArrayList<date_time>):RecyclerView.Adapter<date_time_adapter.vh>() {
    class vh(ItemView:View):ViewHolder(ItemView){
        val day_name:TextView=itemView.findViewById(R.id.tv_day_name)
        val day_number:TextView=itemView.findViewById(R.id.tv_day_number)
        val month_name:TextView=itemView.findViewById(R.id.tv_month_name)
        val time:TextView=itemView.findViewById(R.id.tv_time)
        val card1:CardView=itemView.findViewById(R.id.cardview_date)
        val card2:CardView=itemView.findViewById(R.id.card_time)
        val linear:LinearLayout=itemView.findViewById(R.id.liner)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): vh {
        val View=LayoutInflater.from(parent.context).inflate(R.layout.date_time,null)
        return vh(View)
    }

    override fun getItemCount(): Int {
        return arr.size
    }

    @SuppressLint("RestrictedApi")
    override fun onBindViewHolder(holder: vh, position: Int) {
        var check:Boolean=true
        var check1:Boolean=true

        val ar=arr[position]
        holder.day_name.text=ar.day_name
        holder.day_number.text=ar.day_number
        holder.month_name.text=ar.month_name
        holder.time.text=ar.time

        holder.card1.setOnClickListener{

            if(check){
               holder.card1.setCardBackgroundColor(ContextCompat.getColor(holder.card1.context,R.color.bibs))
                check=false

            }
            else if(check==false){
                holder.card1.setCardBackgroundColor(ContextCompat.getColor(holder.card1.context,R.color.zozoz))
                check=true

            }



        }

        holder.card2.setOnClickListener{
            if(check1){
                holder.card2.setCardBackgroundColor(ContextCompat.getColor(holder.card1.context,R.color.bibs))

                check1=false

            }
            else if(check1==false){
                holder.card2.setCardBackgroundColor(ContextCompat.getColor(holder.card1.context,R.color.zozoz))
                check1=true

            }



        }
    }

}