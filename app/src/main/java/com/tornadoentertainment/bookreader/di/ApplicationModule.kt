package com.tornadoentertainment.bookreader.di

import android.content.Context
import com.google.firebase.firestore.FirebaseFirestore
import com.tornadoentertainment.bookreader.application.BookApplication
import com.tornadoentertainment.bookreader.features.authenticator.Authenticator
import com.tornadoentertainment.bookreader.features.navigator.Navigator
import com.tornadoentertainment.common.data.network.FireBaseClient
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(private val application: BookApplication) {

    @Provides
    @Singleton
    fun provideMoneyForwardApplication(): BookApplication {
        return application
    }

    @Provides
    @Singleton
    fun provideContext(): Context {
        return application.applicationContext
    }

    @Provides
    @Singleton
    fun provideNavigator(authenticator: Authenticator): Navigator {
        return Navigator(authenticator)
    }

    @Provides
    @Singleton
    fun provideAuthenticator(): Authenticator {
        return Authenticator()
    }

    @Provides
    @Singleton
    fun provideFirebaseFireStore(): FirebaseFirestore {
        return FireBaseClient.provideFirebaseFireStore()
    }

}
