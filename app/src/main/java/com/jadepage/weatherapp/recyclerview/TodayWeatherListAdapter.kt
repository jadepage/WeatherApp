package com.jadepage.weatherapp.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.jadepage.weatherapp.databinding.TodayWeatherItemBinding
import com.jadepage.weatherapp.models.TodayWeatherModel

class TodayWeatherListAdapter : ListAdapter
    <TodayWeatherModel, TodayWeatherListAdapter.TodayWeatherViewHolder>(diffUtil) {

    companion object {
        private val diffUtil = object : DiffUtil.ItemCallback<TodayWeatherModel>() {
            override fun areItemsTheSame(
                oldItem: TodayWeatherModel,
                newItem: TodayWeatherModel
            ) = true

            override fun areContentsTheSame(
                oldItem: TodayWeatherModel,
                newItem: TodayWeatherModel
            ): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodayWeatherViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = TodayWeatherItemBinding.inflate(inflater)
        return TodayWeatherViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TodayWeatherViewHolder, position: Int) {
        val item = getItem(position)
        holder.onBind(item)
    }

    class TodayWeatherViewHolder(
        private val binding: TodayWeatherItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun onBind(weather: TodayWeatherModel) {
            binding.apply {
                weatherTime.text = weather.weather_time
                weatherIcon.setImageResource(weather.weather_icon)
            }
        }
    }


}