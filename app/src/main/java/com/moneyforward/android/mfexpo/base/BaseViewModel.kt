package com.moneyforward.android.mfexpo.base

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.moneyforward.android.common.exception.Failure

/**
 * Created by Kan on 6/7/19
 * Copyright © 2018 Money Forward, Inc. All rights
 */
abstract class BaseViewModel : ViewModel() {

    var failure: MutableLiveData<Failure> = MutableLiveData()
    var isLoading: MutableLiveData<Boolean> = MutableLiveData()

    protected open fun handleFailure(failure: Failure) {
        this.isLoading.value = false
        this.failure.value = failure
    }

    protected fun isCanLoadData() = when (isLoading.value) {
        true -> false
        else -> true
    }
}