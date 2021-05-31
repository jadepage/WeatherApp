package com.jadepage.weatherapp.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.jadepage.weatherapp.databinding.TodayWeatherItemBinding
import com.jadepage.weatherapp.models.WeatherModel

class TodayWeatherListAdapter(
        private val weather: List<WeatherModel>
) : RecyclerView.Adapter<TodayWeatherListAdapter.TodayWeatherListViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodayWeatherListViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = TodayWeatherItemBinding.inflate(layoutInflater, parent, false)
        return TodayWeatherListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TodayWeatherListViewHolder, position: Int) {
        holder.bind(weather[position])
    }

    override fun getItemCount() = weather.size

    class TodayWeatherListViewHolder(
            private val binding: TodayWeatherItemBinding
        ) : RecyclerView.ViewHolder(binding.root) {

            fun bind(weather: WeatherModel) {
                binding.apply {
                    weatherTime.text = weather.weather_time
                    weatherIcon.setImageResource(weather.weather_icon)
                    weatherTemperature.text = weather.weather_temp
            }
        }
    }
}