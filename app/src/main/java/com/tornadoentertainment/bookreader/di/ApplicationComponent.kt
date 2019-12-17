package com.tornadoentertainment.bookreader.di


import android.content.Context
import com.google.firebase.firestore.FirebaseFirestore
import com.tornadoentertainment.bookreader.application.BookApplication
import com.tornadoentertainment.bookreader.features.splash.SplashActivity
import dagger.Component
import javax.inject.Singleton

/**
 * Created by Kan on 6/7/19
 * Copyright © 2018 Money Forward, Inc. All rights
 */

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    /**
     * get MoneyForwardApplication
     *
     * @return [BookApplication] data type
     */
    fun getApplication(): BookApplication

    /**
     * get Context
     *
     * @return [Context] data type
     */
    fun getContext(): Context

    /**
     * get FirebaseFireStore
     *
     * @return [FirebaseFirestore] data type
     */
    fun getFirebaseFirestore(): FirebaseFirestore

    /**
     * inject SplashActivity
     */
    fun inject(activity: SplashActivity)

}