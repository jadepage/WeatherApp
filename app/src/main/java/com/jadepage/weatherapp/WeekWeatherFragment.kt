package com.jadepage.weatherapp

import android.os.Bundle
import androidx.fragment.app.Fragment

class WeekWeatherFragment : Fragment(R.layout.fragment_week_weather) {
    companion object {
        private const val ARG_COUNT = "param2"
        fun newInstance(counter: Int?): WeekWeatherFragment {
            val fragment = WeekWeatherFragment()
            val args = Bundle()
            args.putInt(ARG_COUNT, counter!!)
            fragment.arguments = args
            return fragment
        }
    }
}