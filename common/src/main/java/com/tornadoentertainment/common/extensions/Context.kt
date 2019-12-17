package com.tornadoentertainment.common.extensions

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.net.wifi.WifiManager
import android.provider.Settings
import androidx.core.app.NotificationManagerCompat
import com.tornadoentertainment.common.context.AppPreferences

/**
 * Created by Kan on 2019-07-15
 * Copyright © 2018 Money Forward, Inc. All rights
 */

val Context.networkInfo: NetworkInfo?
    get() {
        val cm = this.getSystemService(Context.CONNECTIVITY_SERVICE) as? ConnectivityManager
        return cm?.activeNetworkInfo
    }

fun Context.areNotificationsEnabled(): Boolean {
    return NotificationManagerCompat.from(this).areNotificationsEnabled()
}

@SuppressLint("HardwareIds")
fun Context.getDeviceId(): String {
    AppPreferences.DEVICE_ID.getString().also {
        if (it.isNotEmpty() && it.isNotBlank()) {
            return it
        }
    }

    var deviceId = Settings.Secure.getString(contentResolver, Settings.Secure.ANDROID_ID)

    if (deviceId.isNullOrEmpty()) {
        val wifiManager = this.getSystemService(Context.WIFI_SERVICE) as? WifiManager
        deviceId = wifiManager?.connectionInfo?.macAddress ?: String.empty()
    }

    AppPreferences.DEVICE_ID.set(deviceId)

    return deviceId
}