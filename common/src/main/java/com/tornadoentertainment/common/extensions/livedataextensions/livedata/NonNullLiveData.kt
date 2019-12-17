package com.tornadoentertainment.common.extensions.livedataextensions.livedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.Observer

/**
 * Created by Kan on 2019-11-10
 * Copyright © 2018 Money Forward, Inc. All rights
 */


class NonNullLiveData<T>(liveData: LiveData<T>) : LiveData<T>() {
    private val mediatorLiveData = MediatorLiveData<T>()
    private val mediatorObserver = Observer<T> {
        it?.let {
            this@NonNullLiveData.value = it
        }
    }

    init {
        mediatorLiveData.observeForever(mediatorObserver)
        mediatorLiveData.addSource(liveData, mediatorObserver)
    }

    override fun onInactive() {
        super.onInactive()
        mediatorLiveData.removeObserver(mediatorObserver)
    }

}
