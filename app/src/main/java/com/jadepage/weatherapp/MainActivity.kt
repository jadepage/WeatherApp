package com.jadepage.weatherapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import com.jadepage.weatherapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.viewPager.adapter = PagerAdapter(this)
        TabLayoutMediator(binding.weatherMenu, binding.viewPager) { tab, text ->
            tab.text = tab.text
            binding.viewPager.setCurrentItem(tab.position, true)
        }.attach()
    }
}