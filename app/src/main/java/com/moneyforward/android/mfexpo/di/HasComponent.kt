package com.moneyforward.android.mfexpo.di

/**
 * Created by Kan on 6/7/19
 * Copyright © 2018 Money Forward, Inc. All rights
 */
interface HasComponent<out C> {
    fun getComponent(): C
}