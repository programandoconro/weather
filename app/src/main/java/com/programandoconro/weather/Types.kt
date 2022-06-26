package com.programandoconro.weather

data class Coord(
    val lon: String,
    val lat: String
)
data class WeatherType(
    val coord: Coord,
    val weather: List<WeatherInfo>,
    val base: String,
    val main: Main,
    val visibility: String,
    val wind: Wind,
    val clouds: Clouds,
    val dt: String,
    val sys: Sys,
    val timezone: Long,
    val id: Long,
    val name: String,
    val cod: Int
)
data class WeatherInfo(
    val id: String,
    val main: String,
    val description: String,
    val icon: String,
)
data class Main(
    val temp:String,
    val feels_like:String,
    val temp_min: String,
    val temp_max: String,
    val pressure: String,
    val humidity: String,

    )
data class Wind(
    val speed: String,
    val deg: String
)
data class Clouds(
    val all : String
)
data class Sys(
    val type: Int,
    val id: String,
    val country: String,
    val sunrise: Long,
    val sunset: Long,

    )