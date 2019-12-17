package com.tornadoentertainment.common.extensions.livedataextensions.livedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.Observer

/**
 * Created by Kan on 2019-11-10
 * Copyright © 2018 Money Forward, Inc. All rights
 */

class SingleLiveData<T>(liveData: LiveData<T>) : MediatorLiveData<T>() {
    private var hasSetValue = false
    private val mediatorObserver = Observer<T> {
        if (!hasSetValue) {
            hasSetValue = true
            this@SingleLiveData.value = it
        }
    }

    init {
        if (liveData.value != null) {
            hasSetValue = true
            this.value = liveData.value
        } else {
            addSource(liveData, mediatorObserver)
        }
    }


}