package com.moneyforward.android.mfexpo.features.splash

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.moneyforward.android.mfexpo.R
import com.moneyforward.android.mfexpo.base.BaseActivity
import com.moneyforward.android.mfexpo.features.navigator.Navigator
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Kan on 6/7/19
 * Copyright © 2018 Money Forward, Inc. All rights
 */
class SplashActivity : BaseActivity() {

    companion object {

        private const val TIME_SPLASH_DURATION: Long = 1500

        fun createIntent(context: Context) = Intent(context, SplashActivity::class.java)
    }

    @Inject
    lateinit var navigator: Navigator

    override fun layoutId() = R.layout.activity_splash

    override fun inject() = applicationComponent().inject(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        GlobalScope.launch {
            delay(TIME_SPLASH_DURATION)
            navigator.showNavigation(this@SplashActivity)
            finish()
        }
    }
}
