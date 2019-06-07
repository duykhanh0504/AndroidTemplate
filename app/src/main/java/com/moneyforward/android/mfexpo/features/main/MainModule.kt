package com.moneyforward.android.mfexpo.features.main

import android.arch.lifecycle.ViewModelProvider
import com.moneyforward.android.mfexpo.di.PerActivity
import com.moneyforward.android.mfexpo.di.viewmodel.ViewModelFactory
import dagger.Module
import dagger.Provides

/**
 * Created by Kan on 6/7/19
 * Copyright © 2018 Money Forward, Inc. All rights
 */
@Module
class MainModule {

    @Provides
    @PerActivity
    fun provideViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory {
        return factory
    }
}