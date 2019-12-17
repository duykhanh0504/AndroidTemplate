package com.tornadoentertainment.common.context

import android.content.SharedPreferences
import android.util.Base64
import com.tornadoentertainment.common.extensions.empty

/**
 * This is Helper class of [SharedPreferences]
 * Created by Nguyen Quoc Cuong on 11/28/18.
 * Copyright © 2018 Money Forward, Inc. All rights
 */
interface BasePreferences {

    val key: String

    /**
     * Returns SharedPreferences of android context
     */
    fun getSharedPreferences(): SharedPreferences

    /**
     * Set the value
     * @param value Any data tye
     */
    fun set(value: Any) {
        val encoded = Base64.encodeToString(value.toString().toByteArray(), Base64.DEFAULT)
        val sp = getSharedPreferences()
        sp.edit().putString(key, encoded).apply()
    }

    /**
     *
     * It gets the value.
     *
     * @return Value if the value exists, otherwise it returns null
     */
    fun get(): Any? {
        val sp = getSharedPreferences()
        val encoded: String? = sp.getString(key, null)
        var value: String? = null
        encoded?.let {
            try {
                val decoded = Base64.decode(it.toByteArray(), Base64.DEFAULT)
                value = String(decoded)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        return value
    }

    /**
     * It get the value String
     * Returns Value if the value exists, otherwise it returns empty
     */
    fun getString(): String {
        val any: Any? = get()
        return any?.toString() ?: String.empty()
    }

    /**
     * It get the value Int
     * @param defValue default value
     * Returns Value if the value exists, otherwise it returns defValue
     */
    fun getInt(defValue: Int): Int {
        val any: Any? = get()
        return any?.toString()?.toIntOrNull() ?: defValue
    }

    /**
     * It get the value Long
     * @param defValue default value
     * Returns Value if the value exists, otherwise it returns defValue
     */
    fun getLong(defValue: Long): Long {
        val any: Any? = get()
        return any?.toString()?.toLongOrNull() ?: defValue
    }

    /**
     * It get the value Boolean
     * @param defValue default value
     * Returns Value if the value exists, otherwise it returns defValue
     */
    fun getBoolean(defValue: Boolean): Boolean {
        val any: Any? = get()
        return any?.toString()?.toBoolean() ?: defValue
    }

    /**
     * remove key
     */
    fun remove() {
        val sp = getSharedPreferences()
        sp.edit().remove(key).apply()
    }
}