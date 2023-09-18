package com.jhonataplt.eletriccarapp.ui.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.jhonataplt.eletriccarapp.ui.CarFragment
import com.jhonataplt.eletriccarapp.ui.FavoritesFragment


class TabAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> CarFragment()
            1 -> FavoritesFragment()
            else -> CarFragment()
        }
    }


}