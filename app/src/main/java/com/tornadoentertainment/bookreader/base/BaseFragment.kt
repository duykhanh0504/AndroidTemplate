package com.tornadoentertainment.bookreader.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.tornadoentertainment.bookreader.di.HasComponent
import com.tornadoentertainment.bookreader.base.BaseActivity

abstract class BaseFragment : Fragment() {

    protected abstract fun layoutId(): Int

    /**
     * inject dagger2
     */
    protected abstract fun inject()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(layoutId(), container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        inject()
    }

    /**
     * Returns BaseActivity. Otherwise return null
     */
    protected fun baseActivity() = requireActivity() as? BaseActivity

    /**
     * show progress dialog from [BaseActivity]
     */
    protected fun showProgressDialog() {
        baseActivity()?.showProgressDialog()
    }

    /**
     * hide progress dialog from [BaseActivity]
     */
    protected fun dismissProgressDialog() {
        baseActivity()?.dismissProgressDialog()
    }

    protected fun notify(view: View, message: String) {
        baseActivity()?.notify(view, message)
    }

    /**
     * get component [C] to inject objects
     */
    protected fun <C> getComponent(componentType: Class<C>): C? {
        return componentType.cast((activity as HasComponent<*>).getComponent())
    }

}
