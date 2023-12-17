package com.example.cinematic.ui

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class pager_adapter(Activit:FragmentActivity,val arr:List<Fragment>):FragmentStateAdapter(Activit) {
    override fun getItemCount(): Int {
        return arr.size
    }

    override fun createFragment(position: Int): Fragment {
        return arr[position]
    }
}