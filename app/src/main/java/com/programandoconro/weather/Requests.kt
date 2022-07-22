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

    suspend fun getFutureWeather(lat: String, lon: String): FutureWeatherType? {
        val url =
            "https://api.openweathermap.org/data/2.5/forecast"
        val apiKey = ApiKey().openWeatherApiKey
        var myFutureWeather: FutureWeatherType? = null

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
            val gson = Gson().newBuilder().create()
            val parseJson = gson.fromJson(response?.bodyAsText(), FutureWeatherType::class.java)
            myFutureWeather = parseJson


        } catch (e: Exception) {
            println("Exception:$e")
        }
        client.close()
        return myFutureWeather

    }
}
