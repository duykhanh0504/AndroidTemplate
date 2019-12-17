package com.tornadoentertainment.bookreader.features.authenticator

import com.tornadoentertainment.common.context.UserPreferences
import javax.inject.Inject

class Authenticator @Inject constructor() {

    private val userId: String get() = UserPreferences.USER_ID.getString()

    val isAccountExist: Boolean get() = userId.isNotEmpty()

}
