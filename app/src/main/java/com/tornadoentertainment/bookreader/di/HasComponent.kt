package com.tornadoentertainment.bookreader.di

interface HasComponent<out C> {
    fun getComponent(): C
}