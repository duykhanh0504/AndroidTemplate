package com.moneyforward.android.mfexpo.application

import com.moneyforward.android.common.application.BaseApplication
import com.moneyforward.android.mfexpo.di.ApplicationComponent
import com.moneyforward.android.mfexpo.di.ApplicationModule
import com.moneyforward.android.mfexpo.di.DaggerApplicationComponent

/**
 * Created by Kan on 6/7/19
 * Copyright © 2018 Money Forward, Inc. All rights
 */
class ExpoApplication : BaseApplication() {

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
    }

}