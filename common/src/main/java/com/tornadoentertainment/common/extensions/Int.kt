package com.tornadoentertainment.common.extensions

import com.tornadoentertainment.common.utils.ResourceUtil

/**
 * Created by Kan on 6/11/19
 * Copyright © 2018 Money Forward, Inc. All rights
 */

val Int.Companion.NON_SET: Int get() = -1

val Int.Companion.SETTING_DEFAULT: Int get() = 1

val Int.dp: Float
    get() = (this / ResourceUtil.getScreenSize().density)
val Int.px: Float
    get() = (this * ResourceUtil.getScreenSize().density)