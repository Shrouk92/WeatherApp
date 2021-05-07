package com.example.weather_api_app.ui.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weather_api_app.Data.WAPI
import com.example.weather_api_app.response.Currentweather
private const val Appid:String="fe7d59c0780f5cdce09f843250d3c11e"
private const val units:String="metric"

class WeatherViewModel :ViewModel()
{

     var City = MutableLiveData<String>()
    private val API_Response=MutableLiveData<Currentweather>()

    init {
        get_Weather()
    }
     fun get_Weather(  )
    {
        WAPI.API_service.get_current_weather(City.toString(),Appid , units)
    }
}