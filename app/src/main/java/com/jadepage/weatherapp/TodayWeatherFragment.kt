package com.jadepage.weatherapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jadepage.weatherapp.databinding.FragmentTodayWeatherBinding
import com.jadepage.weatherapp.databinding.TodayWeatherItemBinding
import com.jadepage.weatherapp.recyclerview.TodayWeatherListAdapter

class TodayWeatherFragment : Fragment() {


    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_today_weather, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentTodayWeatherBinding.inflate(layoutInflater)
        binding.weatherTodayList.apply {
            adapter = TodayWeatherListAdapter(

            )
        }

        }
    }


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