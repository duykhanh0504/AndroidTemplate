package com.tornadoentertainment.common.exception

sealed class Failure {

    object NetworkConnection : Failure()
    object ServerError : Failure()
    object AuthenticateFail : Failure()
    class BadRequest(val message: String) : Failure()

    /** * Extend this class for feature specific failures.*/
    abstract class FeatureFailure : Failure()
}