package com.kelway.cosmoalias

import android.content.Context
import com.kelway.cosmoalias.data.di.RoomModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [RoomModule::class, ])
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun buildContext(context: Context): Builder
        fun build(): AppComponent
    }
}