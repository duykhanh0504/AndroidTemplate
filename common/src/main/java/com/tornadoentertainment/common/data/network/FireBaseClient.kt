package com.tornadoentertainment.common.data.network

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreSettings

/**
 * Created by Kan on 2019-12-17
 * Copyright © 2018 Money Forward, Inc. All rights
 */
object FireBaseClient {

    fun provideFirebaseFireStore(): FirebaseFirestore {
        val firebaseFirestore = FirebaseFirestore.getInstance()
        val settings = FirebaseFirestoreSettings.Builder()
            .setPersistenceEnabled(true)
            .build()
        firebaseFirestore.firestoreSettings = settings
        return firebaseFirestore
    }
}