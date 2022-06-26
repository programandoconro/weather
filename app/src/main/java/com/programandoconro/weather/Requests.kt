package com.programandoconro.weather

import com.google.gson.Gson
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

class Requests {

    suspend fun getCurrentWeather(lat: String, lon: String): WeatherType? {
        val url =
            "https://api.openweathermap.org/data/2.5/weather"

        val apiKey = ApiKey().openWeatherApiKey

        val client = HttpClient {
            install(ContentNegotiation) {
                json(
                    Json {
                        prettyPrint = true
                        isLenient = true
                    }

                )
            }
        }
        var myWeather: WeatherType? = null
        try {
            val response: HttpResponse? = client.get(url) {
                contentType(ContentType.Application.Json)
                url {
                    parameters.append("appid", apiKey)
                    parameters.append("lat", lat)
                    parameters.append("lon", lon)
                    parameters.append("units", "metric")


                }
            }.body()
            println(response)
            val gson = Gson().newBuilder().create()
            val parseJson = gson.fromJson(response?.bodyAsText(), WeatherType::class.java)
            myWeather = parseJson

            println(parseJson)
            println("Weather: ${response?.bodyAsText()}")

        } catch (e: Exception) {
            println("Exception:$e")
        }
        return myWeather


    }
}
