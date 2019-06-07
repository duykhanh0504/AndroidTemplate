package com.moneyforward.android.mfexpo.base

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.moneyforward.android.common.extensions.empty
import com.moneyforward.android.mfexpo.application.ExpoApplication
import com.moneyforward.android.mfexpo.di.ApplicationComponent

/**
 * Created by Kan on 6/7/19
 * Copyright © 2018 Money Forward, Inc. All rights
 */
abstract class BaseActivity : AppCompatActivity() {


    private var progressDialogFragment: ProgressDialogFragment? = null
    /**
     * returns id of layout
     */
    protected abstract fun layoutId(): Int

    /**
     * inject dagger2
     */
    protected abstract fun inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        inject()
        setContentView(layoutId())
    }

    /**
     * add fragment
     */
    fun addFragment(containerViewId: Int, fragment: Fragment, backToStack: Boolean = false) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(containerViewId, fragment)
        if (backToStack) {
            transaction.addToBackStack(String.empty())
        }
        transaction.commit()
    }

    /**
     * replace fragment
     */
    fun replaceFragment(
        containerViewId: Int,
        fragment: Fragment,
        animationId: Int = -1,
        backToStack: Boolean = false
    ) {
        val transaction = supportFragmentManager.beginTransaction()
        if (animationId != -1) {
            transaction.setCustomAnimations(animationId, 0, 0, 0)
        }
        if (backToStack) {
            transaction.addToBackStack(String.empty())
        }
        transaction.replace(containerViewId, fragment)
        transaction.commit()
    }

    /**
     * show progress dialog
     */
    internal fun showProgressDialog() {
        if (progressDialogFragment != null) {
            return
        }

        progressDialogFragment = ProgressDialogFragment.newInstance().apply {
            show(supportFragmentManager, ProgressDialogFragment.TAG)
        }
    }

    /**
     * hide progress dialog
     */
    internal fun dismissProgressDialog() {
        progressDialogFragment?.dismiss()
        progressDialogFragment = null
    }

    internal fun notify(view: View, message: String) = Snackbar.make(view, message, Snackbar.LENGTH_SHORT).show()

    /**
     * @return [ApplicationComponent]
     */
    fun applicationComponent(): ApplicationComponent {
        return (application as ExpoApplication).applicationComponent
    }
}