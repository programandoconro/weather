package com.programandoconro.weather

import android.annotation.SuppressLint
import android.content.Context
import android.content.Context.LOCATION_SERVICE
import android.location.Location
import android.location.LocationManager
import android.os.Build

class Coordinates(context: Context) {
    private var mLocation: Location? = null

    private val mGpsLocationClient: LocationManager =
        context.getSystemService(LOCATION_SERVICE) as LocationManager

    @SuppressLint("MissingPermission")
    fun getCurrentLocation(): Location? {
        mLocation = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            mGpsLocationClient.getLastKnownLocation(LocationManager.FUSED_PROVIDER)
        } else {
            mGpsLocationClient.getLastKnownLocation(LocationManager.NETWORK_PROVIDER)

        }
        return mLocation

    }
}