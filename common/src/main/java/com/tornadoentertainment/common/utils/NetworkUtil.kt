package com.tornadoentertainment.common.utils

import android.content.Context
import com.tornadoentertainment.common.extensions.networkInfo
import com.tornadoentertainment.common.application.BaseApplication

/**
 * Created by Kan on 2019-07-15
 * Copyright © 2018 Money Forward, Inc. All rights
 */
object NetworkUtil {

    private val context: Context get() = BaseApplication.INSTANCE.applicationContext

    fun isConnected(): Boolean = context.networkInfo?.isConnectedOrConnecting ?: false

}