package com.tornadoentertainment.common.context

import android.content.Context
import com.tornadoentertainment.common.application.BaseApplication

/**
 * This is the application preferences
 * Created by Nguyen Quoc Cuong on 11/28/18.
 * Copyright © 2018 Money Forward, Inc. All rights
 */
enum class AppPreferences(override val key: String) : BasePreferences {

    VERSION("version"),
    APP_VERSION("app_version"),
    DEVICE_ID("device_id");

    companion object {
        /*** Save when a file name  */
        private const val FILE_NAME = "app_pref"

    }

    override fun getSharedPreferences(): android.content.SharedPreferences {
        return BaseApplication.INSTANCE.applicationContext.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
    }


}