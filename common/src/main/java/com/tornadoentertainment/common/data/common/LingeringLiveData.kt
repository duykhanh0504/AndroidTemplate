package com.tornadoentertainment.common.data.common

import androidx.annotation.CallSuper
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * Created by Kan on 2019-11-25
 * Copyright © 2018 Money Forward, Inc. All rights
 */

abstract class LingeringLiveData<T> : MutableLiveData<T>() {

    companion object {
        const val STOP_LISTENING_DELAY = 1000L
    }

    private var stopLingeringPending = false

    /**
     * Called during onActive, but only if it was not previously in a
     * "lingering" state.
     */
    abstract fun beginLingering()

    /**
     * Called two seconds after onInactive, but only if onActive is not
     * called during that time.
     */
    abstract fun endLingering()

    @CallSuper
    override fun onActive() {
        if (!stopLingeringPending) {
            beginLingering()
        }
        stopLingeringPending = false
    }

    @CallSuper
    override fun onInactive() {
        GlobalScope.launch(Dispatchers.Main) {
            delay(STOP_LISTENING_DELAY)
            if (stopLingeringPending) {
                stopLingeringPending = false
                endLingering()
            }
        }
        stopLingeringPending = true
    }
}