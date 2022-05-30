package com.kelway.cosmoalias.utils.di

import com.kelway.cosmoalias.utils.preference.SharedPreferencesManager
import com.kelway.cosmoalias.utils.preference.SharedPreferencesManagerImpl
import com.kelway.cosmoalias.utils.resource_provider.ResourceProvider
import com.kelway.cosmoalias.utils.resource_provider.ResourceProviderImpl
import dagger.Binds
import dagger.Module

@Module
interface UtilsModule {

    @Binds
    fun bindsSharedPreferencesManager(sharedPreferencesManagerImpl: SharedPreferencesManagerImpl): SharedPreferencesManager

    @Binds
    fun bindsResourceProvider(resourceProviderImpl: ResourceProviderImpl): ResourceProvider
}