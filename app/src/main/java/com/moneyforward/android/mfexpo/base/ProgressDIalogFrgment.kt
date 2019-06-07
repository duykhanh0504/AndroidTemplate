package com.moneyforward.android.mfexpo.base

import android.app.Dialog
import android.graphics.Color
import android.graphics.PorterDuff
import android.os.Build
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.view.Window
import com.moneyforward.android.common.utils.ResourceUtil
import com.moneyforward.android.mfexpo.R
import kotlinx.android.synthetic.main.progress_bar_common.*

/**
 * Created by Kan on 6/7/19
 * Copyright © 2018 Money Forward, Inc. All rights
 */
class ProgressDialogFragment : DialogFragment() {

    companion object {
        const val TAG = "TAG_PROGRESS_DIALOG"

        fun newInstance(): ProgressDialogFragment = ProgressDialogFragment()
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return Dialog(requireContext()).apply {
            requestWindowFeature(Window.FEATURE_NO_TITLE)
            window?.apply {
                setBackgroundDrawable(ResourceUtil.getColorDrawable(Color.TRANSPARENT))
                setDimAmount(0.2f)
            }
            setContentView(R.layout.dialog_loading)
            setCanceledOnTouchOutside(false)
            isCancelable = false

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                progressBar.indeterminateTintList = ResourceUtil.getColorStateList(R.color.colorAccent)
                progressBar.indeterminateTintMode = PorterDuff.Mode.MULTIPLY
            }
        }
    }

}