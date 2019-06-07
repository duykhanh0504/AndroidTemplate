package com.moneyforward.android.mfexpo.extensions

import android.support.annotation.LayoutRes
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by Kan on 6/7/19
 * Copyright © 2018 Money Forward, Inc. All rights
 */
fun View.isVisible() = this.visibility == View.VISIBLE

fun View.visible() {
    this.visibility = View.VISIBLE
}

fun View.invisible() {
    this.visibility = View.INVISIBLE
}

fun View.gone() {
    this.visibility = View.GONE
}

fun ViewGroup.inflate(@LayoutRes layoutRes: Int): View =
    LayoutInflater.from(context).inflate(layoutRes, this, false)

fun View.setLayoutParams(size: Int) {
    val layoutParam = this.layoutParams
    layoutParam.width = size
    layoutParam.height = size
    this.layoutParams = layoutParam
}