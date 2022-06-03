package com.kelway.cosmoalias.utils.preference

import android.content.Context
import javax.inject.Inject

class SharedPreferencesManagerImpl @Inject constructor(private val context: Context): SharedPreferencesManager {

    companion object {
        const val APP_PREFERENCES = "SETTING_GAME"
    }

    private val preferences by lazy { context.getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE) }

    override fun save(key: String, value: String) {
        preferences.edit()
            .putString(key, value)
            .apply()
    }

    override fun getPref(key: String, defaultValue: String): String {
        return preferences.getString(key, defaultValue).toString()
    }

    override fun saveBoolean(key: String, value: Boolean) {
        preferences.edit()
            .putBoolean(key, value)
            .apply()
    }

    override fun getBoolean(key: String, defaultValue: Boolean): Boolean {
        return preferences.getBoolean(key, defaultValue)
    }

    override fun saveInt(key: String, value: Int) {
        preferences.edit()
            .putInt(key, value)
            .apply()
    }

    override fun getInt(key: String, defaultValue: Int): Int {
        return preferences.getInt(key, defaultValue)
    }
}