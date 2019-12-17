package com.tornadoentertainment.common.extensions

import android.util.Log
import com.tornadoentertainment.common.BuildConfig

/**
 * Created by Nguyen Quoc Cuong on 11/30/18.
 * Copyright © 2018 Money Forward, Inc. All rights
 */

fun Any.logError(message: String) {
    if (BuildConfig.DEBUG) {
        Log.e("EXPO-DEBUG", "${this::class.java.simpleName} : $message")
    }
}

fun Any.logMessage(message: String) {
    if (BuildConfig.DEBUG) {
        Log.d("EXPO-DEBUG", "${this::class.java.simpleName} : $message")
    }
}

fun Any.logApi(message: String) {
    if (BuildConfig.DEBUG) {
        Log.d("API_CLIENT", "${this::class.java.simpleName} : $message")
    }
}