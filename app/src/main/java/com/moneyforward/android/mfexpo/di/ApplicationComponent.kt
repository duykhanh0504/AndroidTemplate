package com.moneyforward.android.mfexpo.di

import android.content.Context
import com.moneyforward.android.mfexpo.application.ExpoApplication
import com.moneyforward.android.mfexpo.features.splash.SplashActivity
import dagger.Component
import javax.inject.Singleton

/**
 * Created by Kan on 6/7/19
 * Copyright © 2018 Money Forward, Inc. All rights
 */

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    /**
     * get MoneyForwardApplication
     *
     * @return [CouponApplication] data type
     */
    fun getApplication(): ExpoApplication

    /**
     * get Context
     *
     * @return [Context] data type
     */
    fun getContext(): Context

    /**
     * inject SplashActivity
     */
    fun inject(activity: SplashActivity)

}