package com.moneyforward.android.mfexpo.di.viewmodel

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.moneyforward.android.mfexpo.di.PerActivity
import javax.inject.Inject
import javax.inject.Provider

/**
 * Created by Kan on 6/7/19
 * Copyright © 2018 Money Forward, Inc. All rights
 */
@PerActivity
class ViewModelFactory @Inject constructor(
    private val creators: Map<Class<out ViewModel>,
            @JvmSuppressWildcards Provider<ViewModel>>
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        val creator = creators[modelClass] ?: creators.asIterable().firstOrNull {
            modelClass.isAssignableFrom(it.key)
        }?.value ?: throw IllegalArgumentException("unknown model class $modelClass")
        return try {
            @Suppress("UNCHECKED_CAST")
            creator.get() as T
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
    }
}