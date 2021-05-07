package com.example.weather_api_app.response

data class Weather(
    val description: String,
    val icon: String,
    val id: Int,
    val main: String
)