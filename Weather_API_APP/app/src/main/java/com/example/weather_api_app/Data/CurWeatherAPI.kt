package com.example.weather_api_app.Data
import com.example.weather_api_app.response.Currentweather
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private const val BaseURL:String="https://api.openweathermap.org/data/2.5/"

 private val Re = Retrofit.Builder()
        .baseUrl(BaseURL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

interface CurWeatherAPI {

    @GET("weather/")
    fun get_current_weather(
            @Query("q" ) Location: String,
            @Query("appid") Appid: String,
            @Query("units") Celsius :String,
            @Query("lang")Lang:String
    ):Call<Currentweather>


}
object WAPI{
    val API_service:CurWeatherAPI by lazy {
           Re.create(CurWeatherAPI::class.java)
    }
    }

