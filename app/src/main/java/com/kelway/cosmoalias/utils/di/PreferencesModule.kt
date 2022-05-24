package com.kelway.cosmoalias.utils.di

import android.content.Context
import com.kelway.cosmoalias.utils.preference.SharedPreferencesManager
import com.kelway.cosmoalias.utils.preference.SharedPreferencesManagerImpl
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface PreferencesModule {

   /* @Provides
    fun bindsSharedPreferencesManager(
        context: Context
    ): SharedPreferencesManager {
        return SharedPreferencesManagerImpl(context = context)
    }*/


    @Binds
    fun bindsSharedPreferencesManager(sharedPreferencesManagerImpl: SharedPreferencesManagerImpl): SharedPreferencesManager
}