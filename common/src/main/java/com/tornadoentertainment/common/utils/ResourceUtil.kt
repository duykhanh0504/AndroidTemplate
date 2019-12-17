package com.tornadoentertainment.common.utils

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.AssetManager
import android.content.res.ColorStateList
import android.content.res.Resources
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.provider.Settings.Secure
import android.util.DisplayMetrics
import androidx.annotation.*
import androidx.core.content.ContextCompat
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat
import com.tornadoentertainment.common.application.BaseApplication
import java.util.*


/**
 * Created by Kan on 6/7/19
 * Copyright © 2018 Money Forward, Inc. All rights
 */
object ResourceUtil {

    private const val ROBOTO_REGULAR = 0
    private const val ROBOTO_MEDIUM = 1
    /**
     * Returns Context.
     */
    private val context: Context get() = BaseApplication.INSTANCE.applicationContext

    fun getString(@StringRes id: Int): String = context.getString(id)

    fun getDimensionPixelSize(@DimenRes id: Int) = context.resources.getDimensionPixelSize(id)

    fun getColor(@ColorRes id: Int) = ContextCompat.getColor(context, id)

    fun getDrawable(@DrawableRes id: Int): Drawable? = ContextCompat.getDrawable(context, id)

    fun getDrawableCompat(@DrawableRes id: Int): Drawable? =
        VectorDrawableCompat.create(context.resources, id, context.theme)

    fun getDimension(@DimenRes id: Int) = context.resources.getDimension(id)

    fun getString(@StringRes id: Int, vararg formatArgs: Any): String =
        context.resources.getString(id, *formatArgs)

    fun getColorDrawable(@ColorInt color: Int): Drawable = ColorDrawable(color)

    fun getColorStateList(@ColorRes id: Int): ColorStateList = ColorStateList.valueOf(getColor(id))

    fun parseColor(colorString: String): Int? = try {
        Color.parseColor(colorString)
    } catch (e: Exception) {
        null
    }

    val locale = Locale.getDefault()

    fun getAssert(): AssetManager = context.assets

    fun getScreenSize(): DisplayMetrics = Resources.getSystem().displayMetrics

    fun getScreenWidthPixels() = getScreenSize().widthPixels

    fun getScreenHeightPixels() = getScreenSize().heightPixels

    @SuppressLint("HardwareIds")
    var getDeviceId = Secure.getString(context.contentResolver, Secure.ANDROID_ID)
}