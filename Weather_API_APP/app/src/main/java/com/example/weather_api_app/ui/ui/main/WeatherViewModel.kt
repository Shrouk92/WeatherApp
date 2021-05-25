package com.example.weather_api_app.ui.ui.main

import android.content.Context
import android.os.Build
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.databinding.ObservableField
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weather_api_app.Data.WAPI
import com.example.weather_api_app.response.Currentweather
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


private const val Appid:String="fe7d59c0780f5cdce09f843250d3c11e"
private const val units:String="metric"

class WeatherViewModel :ViewModel()
{

    val TempratureObserver=ObservableField<String>()
     val ResponseObserver=ObservableField<Currentweather>()
    val CountryObserver=ObservableField<String>()
    val TempratureMaxObserver=ObservableField<String>()
    val TempratureMinObserver=ObservableField<String>()
    val MainWeatherObserver=ObservableField<String>()
    val FeelsLikeObserver=ObservableField<String>()
    val HumidityObserver=ObservableField<String>()
    val PressureObserver=ObservableField<String>()
    val windObserver=ObservableField<String>()
    val cloudsObserver=ObservableField<String>()
    val TimeObserver=ObservableField<String>()


    var City:String = ""

    private val API_Response=MutableLiveData<Currentweather>()
    val api_response:LiveData<Currentweather>
        get()=API_Response
    @RequiresApi(Build.VERSION_CODES.O)
    val current = LocalDateTime.now()

    @RequiresApi(Build.VERSION_CODES.O)
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd   HH:mm")
    @RequiresApi(Build.VERSION_CODES.O)
    val formatted = current.format(formatter)


    public fun get_Weather(view:View)
    {
        val C:Call<Currentweather> = WAPI.API_service.get_current_weather(City,Appid , units)
        C.enqueue( object : Callback<Currentweather> {

            override fun onResponse(call: Call<Currentweather>, response: Response<Currentweather>) {
                API_Response.value=response.body()
                if(API_Response.value!=null){
                    TempratureObserver.set(API_Response.value?.main?.temp.toString()+"°C")
                    CountryObserver.set(API_Response.value?.sys?.country)
                    TempratureMaxObserver.set(API_Response.value?.main?.temp_max.toString()+"°C")
                    TempratureMinObserver.set(API_Response.value?.main?.temp_min.toString()+"°C")
                    MainWeatherObserver.set(API_Response.value?.weather?.get(0)?.description)
                    FeelsLikeObserver.set("Feels Like : "+API_Response.value?.main?.temp.toString()+"°C")
                    HumidityObserver.set(API_Response.value?.main?.humidity.toString()+"%")
                    PressureObserver.set(API_Response.value?.main?.pressure.toString() +"HPa")
                    windObserver.set(API_Response.value?.wind?.speed.toString()+" meter/sec")
                    cloudsObserver.set(API_Response.value?.clouds?.all.toString()+"%")
                    TimeObserver.set(formatted)
                }
                else
                {
                    Toast.makeText(view.context,"Invalid Country",Toast.LENGTH_LONG).show()

                }


            }

            override fun onFailure(call: Call<Currentweather>, t: Throwable) {
               // Log.d("sdnc","sds")

            }
        })
    }












}