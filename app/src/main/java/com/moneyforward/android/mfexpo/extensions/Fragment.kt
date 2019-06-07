package com.moneyforward.android.mfexpo.extensions

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.support.v4.app.Fragment

/**
 * Created by Kan on 6/7/19
 * Copyright © 2018 Money Forward, Inc. All rights
 */
inline fun <reified T : ViewModel> Fragment.viewModel(
    factory: ViewModelProvider.Factory, body: T.() -> Unit
): T {
    val vm = ViewModelProviders.of(this, factory).get(T::class.java)
    vm.body()
    return vm
}