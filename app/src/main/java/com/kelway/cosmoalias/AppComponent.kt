package com.kelway.cosmoalias

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [])
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun buildContext(context: Context): Builder
        fun build(): AppComponent
    }
}