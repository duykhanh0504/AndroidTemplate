package com.moneyforward.android.mfexpo.extensions

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.support.annotation.DrawableRes
import android.widget.ImageView
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.Transformation
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.moneyforward.android.mfexpo.R
import com.moneyforward.android.mfexpo.di.GlideApp


/**
 * Created by Kan on 6/7/19
 * Copyright © 2018 Money Forward, Inc. All rights
 */
fun ImageView.load(
    url: String,
    @DrawableRes background: Int = android.R.color.transparent,
    @DrawableRes placeholderBackground: Int = R.drawable.bg_photo_placeholder
) = load(
    url, ImageView.ScaleType.CENTER, CenterCrop(),
    background = background,
    placeholderBackground = placeholderBackground
)

fun ImageView.load(
    url: String,
    imageScaleType: ImageView.ScaleType = ImageView.ScaleType.CENTER,
    vararg transformations: Transformation<Bitmap>,
    @DrawableRes background: Int = android.R.color.transparent,
    @DrawableRes placeholderBackground: Int = R.drawable.bg_photo_placeholder
) {
    scaleType = imageScaleType
    setBackgroundResource(placeholderBackground)
    GlideApp.with(this).load(url)
        .transforms(*transformations)
        .listener(object : RequestListener<Drawable> {
            override fun onLoadFailed(
                e: GlideException?,
                model: Any?,
                target: Target<Drawable>?,
                isFirstResource: Boolean
            ) = false

            override fun onResourceReady(
                resource: Drawable?,
                model: Any?, target: Target<Drawable>?,
                dataSource: DataSource?, isFirstResource: Boolean
            ): Boolean {
                this@load.setBackgroundResource(background)
                return false
            }

        })
        .into(this)
}

fun ImageView.setLayoutParams(size: Int) {
    val layoutParam = this.layoutParams
    layoutParam.width = size
    layoutParam.height = size
    this.layoutParams = layoutParam
}