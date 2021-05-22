package com.example.weather_api_app.ui.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.weather_api_app.R
import com.example.weather_api_app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    private lateinit var Binding :ActivityMainBinding
    private lateinit var W_ViewModel:WeatherViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

       W_ViewModel= ViewModelProvider(this).get(WeatherViewModel::class.java)
        Binding.weather=W_ViewModel
        Binding.lifecycleOwner=this
        Binding.root
        Binding.b.isVisible=false
        Binding.constraintLayout.isVisible=false
        Binding.imageButton.setOnClickListener(View.OnClickListener {
            W_ViewModel.get_Weather()
            W_ViewModel.api_response.observe(this,{newRespon
            ->
                Binding.b.isVisible=true
                Binding.constraintLayout.isVisible=true
                Binding.textView.text=W_ViewModel.City +","+newRespon.sys.country
                Binding.textView3.text = newRespon.main.temp.toString() +"°C"
                Binding.minTemp.text=newRespon.main.temp_min.toString()+"°C"
                Binding.maxTemp.text=newRespon.main.temp_max.toString()+"°C"
                Binding.FLike.text= "Feels Like :"+newRespon.main.temp.toString()+"°C"
                Binding.textView7.text=newRespon.weather[0].main
                Binding.textView4.text=newRespon.main.humidity.toString()+"%"
                Binding.textView5.text=newRespon.main.pressure.toString() +"HPa"
                Binding.textView6.text=newRespon.wind.toString()+" meter/sec"
                Binding.textView8.text=newRespon.clouds.all.toString()+"%"


            })

        })
















    }
}