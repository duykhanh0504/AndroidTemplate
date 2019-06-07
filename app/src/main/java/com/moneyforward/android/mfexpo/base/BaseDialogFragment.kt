package com.moneyforward.android.mfexpo.base

import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by Kan on 6/7/19
 * Copyright © 2018 Money Forward, Inc. All rights
 */
abstract class BaseDialogFragment : DialogFragment() {

    protected abstract fun layoutId(): Int

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(layoutId(), container, false)
    }

    /**
     * Returns BaseDialogFragment. Otherwise return null
     */
    protected fun baseActivity() = requireActivity() as? BaseActivity

}