package com.example.weather_api_app.ui.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.weather_api_app.R
import com.example.weather_api_app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    private lateinit var Binding :ActivityMainBinding
    private lateinit var W_ViewModel:WeatherViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

       W_ViewModel=ViewModelProviders.of(this).get(WeatherViewModel::class.java)
        Binding.weather=W_ViewModel
        Binding.lifecycleOwner=this
        Binding.root














    }
}