package com.tornadoentertainment.common.extensions

import com.google.firebase.firestore.*
import com.tornadoentertainment.common.exception.DataOrException
import com.tornadoentertainment.common.data.common.LingeringLiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import kotlin.math.max

/**
 * Created by Kan on 2019-06-21
 * Copyright © 2018 Money Forward, Inc. All rights
 */

typealias DocumentSnapshotOrException = DataOrException<QuerySnapshot?, FirebaseFirestoreException?>

abstract class FireStoreCollection<T>(
    private val query: Query,
    private val isSingle: Boolean = false
) : LingeringLiveData<T>(), EventListener<QuerySnapshot> {

    // protected var stopPending = false

    override fun onEvent(snapshot: QuerySnapshot?, e: FirebaseFirestoreException?) {
        //improve in the future
        /* if (!stopPending) {
             stopPending = true
             GlobalScope.launch(Dispatchers.IO) {
                 delay(STOP_LISTENING_DELAY)
                 stopPending = false
             }
         }*/
        if (isSingle) {
            listenerRegistration?.remove()
        }
    }

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

    protected var listenerRegistration: ListenerRegistration? = null

}
