package com.example.weather_api_app.ui.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weather_api_app.Data.WAPI
import com.example.weather_api_app.response.Currentweather
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private const val Appid:String="fe7d59c0780f5cdce09f843250d3c11e"
private const val units:String="metric"

class WeatherViewModel :ViewModel()
{

    var City:String = ""

    private val API_Response=MutableLiveData<Currentweather>()
    val api_response:LiveData<Currentweather>
        get()=API_Response



    public fun get_Weather()
    {
        val C:Call<Currentweather> = WAPI.API_service.get_current_weather(City,Appid , units)
        C.enqueue( object : Callback<Currentweather> {

            override fun onResponse(call: Call<Currentweather>, response: Response<Currentweather>) {
                API_Response.value=response.body()
            }

            override fun onFailure(call: Call<Currentweather>, t: Throwable) {
                Log.d("sdnc","sds")
            }
        })

    }
}