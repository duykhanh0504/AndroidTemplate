package com.tornadoentertainment.bookreader.features.navigator

import android.content.Context
import com.tornadoentertainment.bookreader.features.MainActivity
import com.tornadoentertainment.bookreader.features.authenticator.Authenticator
import javax.inject.Inject

class Navigator @Inject constructor(private val authenticator: Authenticator) {

    companion object {
        const val EVENT_DATA = "eventData"
    }

    fun showMain(context: Context) {
        val intent = MainActivity.createIntent(context)
        context.startActivity(intent)
    }

}
