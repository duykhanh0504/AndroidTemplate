package com.tornadoentertainment.common.context

import android.content.Context
import com.tornadoentertainment.common.application.BaseApplication

/**
 * Created by Kan on 2019-07-16
 * Copyright © 2018 Money Forward, Inc. All rights
 */

enum class UserPreferences(override val key: String) : BasePreferences {
    USER_ID("user_id");

    companion object {
        /*** Save when a file name  */
        private const val FILE_NAME = "user_pref"

        /**
         * Save object AccessToken to Filed Preferences
         */
        fun saveUserInfo(id: String) {
            USER_ID.set(id)
        }
    }

    override fun getSharedPreferences(): android.content.SharedPreferences {
        return BaseApplication.INSTANCE.applicationContext.getSharedPreferences(
            FILE_NAME,
            Context.MODE_PRIVATE
        )
    }

}
