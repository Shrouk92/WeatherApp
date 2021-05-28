package com.example.weather_api_app.ui.ui.main

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.weather_api_app.R
import com.example.weather_api_app.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {


    private lateinit var Binding :ActivityMainBinding
    private lateinit var W_ViewModel:WeatherViewModel

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        W_ViewModel= ViewModelProvider(this).get(WeatherViewModel::class.java)
        Binding.weather=W_ViewModel
        Binding.lifecycleOwner=this
        Binding.root

    }
}