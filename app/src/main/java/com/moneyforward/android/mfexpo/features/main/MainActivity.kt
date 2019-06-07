package com.moneyforward.android.mfexpo.features.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.moneyforward.android.mfexpo.R
import com.moneyforward.android.mfexpo.base.BaseActivity
import com.moneyforward.android.mfexpo.di.HasComponent
import com.moneyforward.android.mfexpo.features.navigator.Navigator
import javax.inject.Inject

class MainActivity : BaseActivity(), HasComponent<MainComponent> {

    companion object {
        fun createIntent(context: Context) = Intent(context, MainActivity::class.java)
    }

    private val mainComponent: MainComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        DaggerMainComponent.builder()
            .applicationComponent(applicationComponent())
            .mainModule(MainModule()).build()
    }

    override fun getComponent() = mainComponent

    @Inject
    lateinit var navigator: Navigator

    override fun layoutId() = R.layout.activity_main

    override fun inject() = getComponent().inject(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}
