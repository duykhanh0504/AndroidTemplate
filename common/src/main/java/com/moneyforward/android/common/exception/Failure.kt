package com.moneyforward.android.common.exception

/**
 * Created by Kan on 6/7/19
 * Copyright © 2018 Money Forward, Inc. All rights
 */
sealed class Failure {

    class NetworkConnection : Failure()
    class ServerError : Failure()
    /** * Extend this class for feature specific failures.*/
    abstract class FeatureFailure : Failure()

}