package com.programandoconro.weather

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {
    private val requests = Requests()

    // TODO: get coors from Location listener and/or Map
    private var lat = "33.5858"
    private val lon = "130.432"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val refreshButton = findViewById<Button>(R.id.buttonRefresh)
        getApiRequest()

        refreshButton.setOnClickListener{
            getApiRequest()
        }
    }

    @SuppressLint("SetTextI18n")
    private fun getApiRequest(){
        showProgressBar(true)
        val weather: TextView = findViewById(R.id.weather)
        var response: WeatherType? = null
        runBlocking {
            launch {
                response = requests.getCurrentWeather(lat, lon)

            }
        }
        weather.text = """
            Temperature: ${response?.main?.temp} 
            Description: ${response?.weather?.get(0)?.main}
            Clouds: ${response?.clouds?.all}%
            
            """.trimIndent()

        showProgressBar(false)

    }
    private fun showProgressBar(show: Boolean) {
        val bar: View = findViewById(R.id.progressBar)
        if (show) {
            bar.visibility = View.VISIBLE
        }
        if (!show) {
            bar.visibility = View.GONE
        }
    }

}