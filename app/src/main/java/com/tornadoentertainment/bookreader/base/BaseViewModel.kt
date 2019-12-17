package com.tornadoentertainment.bookreader.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tornadoentertainment.common.exception.Failure

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