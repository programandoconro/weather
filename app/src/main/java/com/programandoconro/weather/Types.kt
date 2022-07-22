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
    val cod: Int,
    val dt_txt: String
)

data class WeatherInfo(
    val id: String,
    val main: String,
    val description: String,
    val icon: String,
)

data class Main(
    val temp: String,
    val feels_like: String,
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
    val all: String
)

data class Sys(
    val type: Int,
    val id: String,
    val country: String,
    val sunrise: Long,
    val sunset: Long,

    )

//{"cod":"200","message":0,"cnt":40,"list":[{"dt":1658491200,"main":{"temp":25.52,"feels_like":25.72,"temp_min":23.97,"temp_max":25.52,"pressure":1000,"sea_level":1000,"grnd_level":1007,"humidity":61,"temp_kf":1.55},"weather":[{"id":802,"main":"Clouds","description":"scattered clouds","icon":"03n"}],"clouds":{"all":40},"wind":{"speed":1.4,"deg":296,"gust":2.27},"visibility":10000,"pop":0.03,"sys":{"pod":"n"},"dt_txt":"2022-07-22 12:00:00"},{"dt":1658502000,"main":{"temp":24.82,"feels_like":25.16,"temp_min":23.43,"temp_max":24.82,"pressure":1002,"sea_level":1002,"grnd_level":1007,"humidity":69,"temp_kf":1.39},"weather":[{"id":802,"main":"Clouds","description":"scattered clouds","icon":"03n"}],"clouds":{"all":29},"wind":{"speed":0.38,"deg":297,"gust":0.74},"visibility":10000,"pop":0,"sys":{"pod":"n"},"dt_txt":"2022-07-22 15:00:00"},{"dt":1658512800,"main":{"temp":23.75,"feels_like":24.24,"temp_min":22.87,"temp_max":23.75,"pressure":1005,"sea_level":1005,"grnd_level":1006,"humidity":79,"temp_kf":0.88},"weather":[{"id":802,"main":"Clouds","description":"scattered clouds","icon":"03n"}],"clouds":{"all":39},"wind":{"speed":0.62,"deg":254,"gust":0.82},"visibility":10000,"pop":0,"sys":{"pod":"n"},"dt_txt":"2022-07-22 18:00:00"},{"dt":1658523600,"main":{"temp":22.87,"feels_like":23.46,"temp_min":22.87,"temp_max":22.87,"pressure":1007,"sea_level":1007,"grnd_level":1007,"humidity":86,"temp_kf":0},"weather":[{"id":803,"main":"Clouds","description":"broken clouds","icon":"04d"}],"clouds":{"all":59},"wind":{"speed":0.59,"deg":211,"gust":0.66},"visibility":10000,"pop":0.01,"sys":{"pod":"d"},"dt_txt":"2022-07-22 21:00:00"},{"dt":1658534400,"main":{"temp":26.87,"feels_like":28.56,"temp_min":26.87,"temp_max":26.87,"pressure":1008,"sea_level":1008,"grnd_level":1007,"humidity":69,"temp_kf":0},"weather":[{"id":803,"main":"Clouds","description":"broken clouds","icon":"04d"}],"clouds":{"all":54},"wind":{"speed":0.47,"deg":300,"gust":0.92},"visibility":10000,"pop":0.02,"sys":{"pod":"d"},"dt_txt":"2022-07-23 00:00:00"},{"dt":1658545200,"main":{"temp":29.23,"feels_like":31.43,"temp_min":29.23,"temp_max":29.23,"pressure":1007,"sea_level":1007,"grnd_level":1006,"humidity":60,"temp_kf":0},"weather":[{"id":804,"main":"Clouds","description":"overcast clouds","icon":"04d"}],"clouds":{"all":92},"wind":{"speed":2.28,"deg":332,"gust":2.03},"visibility":10000,"pop":0,"sys":{"pod":"d"},"dt_txt":"2022-07-23 03:00:00"},{"dt":1658556000,"main":{"temp":28.12,"feels_like":30.36,"temp_min":28.12,"temp_max":28.12,"pressure":1006,"sea_level":1006,"grnd_level":1006,"humidity":66,"temp_kf":0},"weather":[{"id":804,"main":"Clouds","description":"overcast clouds","icon":"04d"}],"clouds":{"all":93},"wind":{"speed":2.14,"deg":334,"gust":1.76},"visibility":10000,"pop":0,"sys":{"pod":"d"},"dt_txt":"2022-07-23 06:00:00"},{"dt":1658566800,"main":{"temp":26.87,"feels_like":28.87,"temp_min":26.87,"temp_max":26.87,"pressure":1006,"sea_level":1006,"grnd_level":1006,"humidity":73,"temp_kf":0},"weather":[{"id":804,"main":"Clouds","description":"overcast clouds","icon":"04d"}],"clouds":{"all":100},"wind":{"speed":1.69,"deg":345,"gust":1.75},"visibility":10000,"pop":0.06,"sys":{"pod":"d"},"dt_txt":"2022-07-23 09:00:00"},{"dt":1658577600,"main":{"temp":24.87,"feels_like":25.55,"temp_min":24.87,"temp_max":24.87,"pressure":1007,"sea_level":1007,"grnd_level":1006,"humidity":82,"temp_kf":0},"weather":[{"id":804,"main":"Clouds","description":"overcast clouds","icon":"04n"}],"clouds":{"all":100},"wind":{"speed":0.45,"deg":53,"gust":0.71},"visibility":10000,"pop":0,"sys":{"pod":"n"},"dt_txt":"2022-07-23 12:00:00"},{"dt":1658588400,"main":{"temp":24.34,"feels_like":25.02,"temp_min":24.34,"temp_max":24.34,"pressure":1007,"sea_level":1007,"grnd_level":1006,"humidity":84,"temp_kf":0},"weather":[{"id":804,"main":"Clouds","description":"overcast clouds","icon":"04n"}],"clouds":{"all":93},"wind":{"speed":0.79,"deg":192,"gust":0.82},"visibility":10000,"pop":0,"sys":{"pod":"n"},"dt_txt":"2022-07-23 15:00:00"},{"dt":1658599200,"main":{"temp":23.84,"feels
data class FutureWeatherType(
    val cod: String,
    val message: Int,
    val cnt: Int,
    val list: ArrayList<WeatherType>

)