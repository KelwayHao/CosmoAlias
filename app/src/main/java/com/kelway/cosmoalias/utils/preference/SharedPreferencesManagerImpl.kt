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
}