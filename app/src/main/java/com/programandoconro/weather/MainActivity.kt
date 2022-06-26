package com.programandoconro.weather

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {
    private val requests = Requests()
    // TODO: get coor from Location listener and/or Map
    private var lat = "33.5858"
    private val lon = "130.432"
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val weather: TextView = findViewById(R.id.weather)
        var response: WeatherType? = null
        runBlocking {
            launch {

                response = requests.getCurrentWeather(lat, lon)
                println(response)

            }
        }
        weather.text = """
            Temperature: ${response?.main?.temp} 
            Description: ${response?.weather?.get(0)?.main}
            Clouds: ${response?.clouds?.all}%
            
            """.trimIndent()
        // TODO: Add button to reload

    }
}