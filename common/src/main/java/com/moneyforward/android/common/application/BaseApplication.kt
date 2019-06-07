package com.moneyforward.android.common.application

import android.app.Application

/**
 * Created by Kan on 6/7/19
 * Copyright © 2018 Money Forward, Inc. All rights
 */
open class BaseApplication : Application() {

    companion object {
        lateinit var INSTANCE: BaseApplication
    }

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
    }

}