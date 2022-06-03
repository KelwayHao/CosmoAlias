package com.kelway.cosmoalias.utils.preference

interface SharedPreferencesManager {
    fun save(key: String, value: String)
    fun getPref(key: String, defaultValue: String): String
    fun saveBoolean(key: String, value: Boolean)
    fun getBoolean(key: String, defaultValue: Boolean): Boolean
    fun saveInt(key: String, value: Int)
    fun getInt(key: String, defaultValue: Int): Int
}