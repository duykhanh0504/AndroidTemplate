package com.tornadoentertainment.bookreader.base

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.viewpager.widget.ViewPager

/**
 * Created by Kan on 6/10/19
 * Copyright © 2018 Money Forward, Inc. All rights
 */
class BaseViewPager : ViewPager {

    private var enabled = false

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    override fun onTouchEvent(event: MotionEvent): Boolean {
        return this.enabled && super.onTouchEvent(event) && performClick()
    }

    override fun onInterceptTouchEvent(event: MotionEvent): Boolean {
        return this.enabled && super.onInterceptTouchEvent(event)

    }

    override fun performClick(): Boolean {
        return this.enabled && super.performClick()
    }

    override fun setEnabled(enabled: Boolean) {
        this.enabled = enabled
    }

}