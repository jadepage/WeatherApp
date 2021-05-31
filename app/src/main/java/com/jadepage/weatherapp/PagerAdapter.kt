package com.jadepage.weatherapp

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayout


class PagerAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {

    override fun createFragment(position: Int): Fragment {
        when (position){
            0 -> {
                return TodayWeatherFragment.newInstance(position)
            }
            1->{
                return WeekWeatherFragment.newInstance(position)
            }
        }
        return TodayWeatherFragment.newInstance(position)
    }

    override fun getItemCount(): Int {
        return ITEM_COUNT
    }

    companion object {
        private const val ITEM_COUNT = 2
    }
}