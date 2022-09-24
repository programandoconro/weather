package com.programandoconro.weather

import android.annotation.SuppressLint
import android.location.Location
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    private val requests = Requests()

    private var response: FutureWeatherType? = null
    private var counter = 0
    private var maxIndex = 1
    private var mLocation: Location? = null
    private lateinit var fusedLocationClient: FusedLocationProviderClient

    @SuppressLint("MissingPermission")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
        val permission = Permission(this, this)
        if (!permission.isGpsGranted()) {
            permission.requestGps()
        } else {
            fusedLocationClient.lastLocation
                .addOnSuccessListener { location: Location? ->
                    println(location)
                    mLocation = location
                    getApiRequest()
                }

        }

        setContentView(R.layout.activity_main)

        val refreshButton = findViewById<Button>(R.id.buttonRefresh)
        val nextButton = findViewById<Button>(R.id.buttonNext)
        val prevButton = findViewById<Button>(R.id.buttonPrev)

        refreshButton.setOnClickListener {
            getApiRequest()
        }
        nextButton.setOnClickListener {
            if (counter < maxIndex - 1) {
                counter++
                setWeatherText()
                prevButton.isEnabled = true
            } else {
                nextButton.isEnabled = false
            }
        }
        prevButton.setOnClickListener {
            if (counter > 0) {
                counter--
                setWeatherText()
                nextButton.isEnabled = true
            } else {
                prevButton.isEnabled = false
            }
        }
        prevButton.isEnabled = false

    }

    @SuppressLint("SimpleDateFormat")
    private fun getDayOfWeek(dateString: String?): String {
        val date: Date =
            dateString?.let { SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(it) } as Date
        return SimpleDateFormat("EE").format(date)
    }

    @SuppressLint("SetTextI18n")
    private fun setWeatherText() {
        val weather: TextView = findViewById(R.id.weather)

        if (response?.cnt != null) {

            weather.text = """
            Date: ${response?.list?.get(counter)?.dt_txt} ${getDayOfWeek(response?.list?.get(counter)?.dt_txt)}
            Temperature: ${response?.list?.get(counter)?.main?.temp} 
            Description: ${response?.list?.get(counter)?.weather?.get(0)?.main}
            Clouds: ${response?.list?.get(counter)?.clouds?.all}%
            
            """.trimIndent()
        }

    }

    private fun getApiRequest() {
        showProgressBar(true)
        runBlocking {
            launch {
                try {
                    response = requests.getFutureWeather(
                        "${mLocation?.latitude}",
                        "${mLocation?.longitude}"
                    )
                } catch (e: Exception) {
                    println(e)
                }
            }
        }
        if (response != null) {
            maxIndex = response?.cnt!!
            setWeatherText()
            showProgressBar(false)
        }

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