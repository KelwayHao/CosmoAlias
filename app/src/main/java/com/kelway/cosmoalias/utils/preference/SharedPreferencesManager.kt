package com.kelway.cosmoalias.utils.preference

interface SharedPreferencesManager {
    fun save(key: String, value: String)
    fun getPref(key: String, defaultValue: String) : String
}