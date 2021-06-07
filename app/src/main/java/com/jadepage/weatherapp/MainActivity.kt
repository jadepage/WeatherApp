package com.jadepage.weatherapp

import android.Manifest
import android.content.pm.PackageManager
import android.location.Location
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.view.isVisible
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices

import com.google.android.material.tabs.TabLayoutMediator
import com.jadepage.weatherapp.databinding.ActivityMainBinding
import com.jadepage.weatherapp.models.LocationModel
import com.jadepage.weatherapp.networking.Network

class MainActivity : AppCompatActivity() {

    // Global variables for user location
    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private val LOCATION_PERMISSION_REQ_CODE = 1000;

    private var latitude: Double = 0.0
    private var longitude: Double = 0.0

    private var locationModel : LocationModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
        binding.getWeatherBtn.setOnClickListener {
            getCurrentLocation()
            binding.apply {
                currentTimezone.text = latitude.toString()
                weatherType.text = longitude.toString()
                locationModel?.latitude = latitude
                locationModel?.longitude = longitude
            }
        }

        binding.viewPager.adapter = PagerAdapter(this)
        TabLayoutMediator(binding.weatherMenu, binding.viewPager) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "Today"
                }
                else -> {
                    tab.text = "This Week"
                }
            }
            binding.viewPager.setCurrentItem(tab.position, true)
        }.attach()
    }

    private fun getCurrentLocation() {
        // checking location permission
        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION) !=  PackageManager.PERMISSION_GRANTED) {

            // request permission
            ActivityCompat.requestPermissions(this,
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), LOCATION_PERMISSION_REQ_CODE)
            return
        }
        fusedLocationClient.lastLocation
            .addOnSuccessListener { location ->
                //get the last known or current location
                latitude = location.latitude
                longitude = location.longitude
            }

            .addOnFailureListener {
                Toast.makeText(this, "Failed to get current location",
                Toast.LENGTH_SHORT).show()
            }
    }

    override fun onRequestPermissionsResult(
            requestCode: Int, permissions: Array<out String>, grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            LOCATION_PERMISSION_REQ_CODE -> {
                if (grantResults.isNotEmpty() &&
                        grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // permission granted
                } else {
                    // permission denied
                    Toast.makeText(this, "You need to grant permission to access location",
                            Toast.LENGTH_SHORT).show()
                }
            }
        }

    }
}


