package com.moneyforward.android.common.utils

import android.content.Context
import android.content.res.AssetManager
import android.content.res.ColorStateList
import android.content.res.Resources
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.support.annotation.*
import android.support.v4.content.ContextCompat
import com.moneyforward.android.common.application.BaseApplication

/**
 * Created by Kan on 6/7/19
 * Copyright © 2018 Money Forward, Inc. All rights
 */
object ResourceUtil {

    /**
     * Returns Context.
     */
    private val context: Context get() = BaseApplication.INSTANCE.applicationContext

    fun getString(@StringRes id: Int): String = context.getString(id)

    fun getDimensionPixelSize(@DimenRes id: Int) = context.resources.getDimensionPixelSize(id)

    fun getColor(@ColorRes id: Int) = ContextCompat.getColor(context, id)

    fun getDrawable(@DrawableRes id: Int): Drawable? = ContextCompat.getDrawable(context, id)

    fun getDimension(@DimenRes id: Int) = context.resources.getDimension(id)

    fun getString(@StringRes id: Int, vararg formatArgs: Any): String = context.resources.getString(id, *formatArgs)

    fun getColorDrawable(@ColorInt color: Int): Drawable = ColorDrawable(color)

    fun getColorStateList(@ColorRes id: Int): ColorStateList = ColorStateList.valueOf(getColor(id))

    fun parseColor(colorString: String): Int? = try {
        Color.parseColor(colorString)
    } catch (e: Exception) {
        null
    }

    fun getAssert(): AssetManager = context.assets

    private fun getScreenSize() = Resources.getSystem().displayMetrics

    fun getScreenWidthPixels() = getScreenSize().widthPixels

    fun getScreenHeightPixels() = getScreenSize().heightPixels

}