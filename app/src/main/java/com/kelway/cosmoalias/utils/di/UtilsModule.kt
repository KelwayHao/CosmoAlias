package com.kelway.cosmoalias.utils.di

import com.kelway.cosmoalias.utils.preference.SharedPreferencesManager
import com.kelway.cosmoalias.utils.preference.SharedPreferencesManagerImpl
import com.kelway.cosmoalias.utils.resource_provider.ResourceProvider
import com.kelway.cosmoalias.utils.resource_provider.ResourceProviderImpl
import com.kelway.cosmoalias.utils.timer.TimerImpl
import com.kelway.cosmoalias.utils.timer.TimerInteractor
import dagger.Binds
import dagger.Module

@Module
interface UtilsModule {

    @Binds
    fun bindsSharedPreferencesManager(sharedPreferencesManagerImpl: SharedPreferencesManagerImpl): SharedPreferencesManager

    @Binds
    fun bindsResourceProvider(resourceProviderImpl: ResourceProviderImpl): ResourceProvider

    @Binds
    fun bindTimeTimer(timerImpl: TimerImpl): TimerInteractor
}