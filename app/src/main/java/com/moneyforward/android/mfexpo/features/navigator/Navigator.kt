package com.moneyforward.android.mfexpo.features.navigator

import android.content.Context
import com.moneyforward.android.mfexpo.features.main.MainActivity
import javax.inject.Inject

/**
 * Created by Kan on 6/7/19
 * Copyright © 2018 Money Forward, Inc. All rights
 */
class Navigator @Inject constructor() {

    private fun showMain(context: Context) {
        val intent = MainActivity.createIntent(context)
        context.startActivity(intent)
    }

    fun showNavigation(context: Context) {
        showMain(context)
    }
}
