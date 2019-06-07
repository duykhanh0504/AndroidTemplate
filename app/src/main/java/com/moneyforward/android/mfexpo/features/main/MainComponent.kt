package com.moneyforward.android.mfexpo.features.main

import com.moneyforward.android.mfexpo.di.ApplicationComponent
import com.moneyforward.android.mfexpo.di.PerActivity
import dagger.Component

/**
 * Created by Kan on 6/7/19
 * Copyright © 2018 Money Forward, Inc. All rights
 */
@PerActivity
@Component(modules = [MainModule::class], dependencies = [ApplicationComponent::class])
interface MainComponent {

    fun inject(activity: MainActivity)
}
