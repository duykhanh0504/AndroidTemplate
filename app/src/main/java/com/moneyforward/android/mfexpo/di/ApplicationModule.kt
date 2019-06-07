package com.moneyforward.android.mfexpo.di

import android.content.Context
import com.moneyforward.android.mfexpo.application.ExpoApplication
import com.moneyforward.android.mfexpo.features.navigator.Navigator
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Kan on 6/7/19
 * Copyright © 2018 Money Forward, Inc. All rights
 */

@Module
class ApplicationModule(private val application: ExpoApplication) {

    @Provides
    @Singleton
    fun provideMoneyForwardApplication(): ExpoApplication {
        return application
    }

    @Provides
    @Singleton
    fun provideContext(): Context {
        return application.applicationContext
    }

    @Provides
    @Singleton
    fun provideNavigator(): Navigator {
        return Navigator()
    }
}