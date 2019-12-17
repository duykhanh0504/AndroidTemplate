package com.tornadoentertainment.common.extensions

import com.google.firebase.firestore.*
import com.tornadoentertainment.common.exception.DataOrException
import com.tornadoentertainment.common.data.common.LingeringLiveData
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import kotlin.math.max

/**
 * Created by Kan on 2019-07-15
 * Copyright © 2018 Money Forward, Inc. All rights
 */
typealias DocumentOrException = DataOrException<DocumentSnapshot?, FirebaseFirestoreException?>

open class FireStoreDocument<T>(
    private val query: DocumentReference,
    private val isSingle: Boolean = false
) : LingeringLiveData<T>(), EventListener<DocumentSnapshot> {

    override fun beginLingering() {
        listenerRegistration = query.addSnapshotListener(cpuExecutorService, this)
    }

    override fun endLingering() {
        listenerRegistration?.remove()
    }

    companion object {
        private val NUM_CPU_THREADS = max(1, Runtime.getRuntime().availableProcessors() - 1)
    }

    private val cpuExecutorService: ExecutorService by lazy {
        Executors.newFixedThreadPool(
            NUM_CPU_THREADS
        )
    }

    private var listenerRegistration: ListenerRegistration? = null

    init {
        listenerRegistration = query.addSnapshotListener(cpuExecutorService, this)
    }

    override fun onEvent(
        documentSnapshot: DocumentSnapshot?,
        exception: FirebaseFirestoreException?
    ) {
        if (isSingle) {
            listenerRegistration?.remove()
        }
    }
}
