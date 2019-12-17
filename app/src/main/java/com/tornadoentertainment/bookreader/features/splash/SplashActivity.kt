package com.tornadoentertainment.bookreader.features.splash

import android.os.Bundle
import com.tornadoentertainment.bookreader.R
import com.tornadoentertainment.bookreader.base.BaseActivity
import com.tornadoentertainment.bookreader.features.navigator.Navigator
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Kan on 2019-12-17
 * Copyright © 2018 Money Forward, Inc. All rights
 */
class SplashActivity : BaseActivity() {

    companion object {
        private const val TIME_SPLASH_DURATION: Long = 1500
    }

    @Inject
    lateinit var navigator: Navigator

    override fun layoutId() = R.layout.activity_splash

    override fun inject() = applicationComponent().inject(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        GlobalScope.launch(Dispatchers.Main) {
            delay(TIME_SPLASH_DURATION)
            navigator.showMain(this@SplashActivity)
            finish()
        }
    }
}