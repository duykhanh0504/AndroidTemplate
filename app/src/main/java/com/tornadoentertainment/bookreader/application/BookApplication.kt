package com.tornadoentertainment.bookreader.application

/**
 * Created by Kan on 2019-12-17
 * Copyright © 2018 Money Forward, Inc. All rights
 */

import com.google.firebase.FirebaseApp
import com.tornadoentertainment.bookreader.di.ApplicationComponent
import com.tornadoentertainment.bookreader.di.ApplicationModule
import com.tornadoentertainment.bookreader.di.DaggerApplicationComponent
import com.tornadoentertainment.common.application.BaseApplication

class BookApplication : BaseApplication() {

    val applicationComponent: ApplicationComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        DaggerApplicationComponent
            .builder()
            .applicationModule(ApplicationModule(this))
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        initialize()
    }

    /**
     * initialize Library : Facebook,ImageLoader...
     */
    private fun initialize() {
        FirebaseApp.initializeApp(this)
    }

}