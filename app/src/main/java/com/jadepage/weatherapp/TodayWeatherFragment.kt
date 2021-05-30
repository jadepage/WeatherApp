package com.jadepage.weatherapp

import android.os.Bundle
import androidx.fragment.app.Fragment

class TodayWeatherFragment : Fragment(R.layout.fragment_today_weather) {
    companion object {
        private const val ARG_COUNT = "param1"
        fun newInstance(counter: Int?): TodayWeatherFragment {
            val fragment = TodayWeatherFragment()
            val args = Bundle()
            args.putInt(ARG_COUNT, counter!!)
            fragment.arguments = args
            return fragment
        }
    }
}