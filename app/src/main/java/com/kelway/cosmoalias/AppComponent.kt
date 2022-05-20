package com.kelway.cosmoalias

import android.content.Context
import com.kelway.cosmoalias.data.di.DataModule
import com.kelway.cosmoalias.data.di.RoomModule
import com.kelway.cosmoalias.domain.di.DomainModule
import com.kelway.cosmoalias.presentation.MainActivity
import com.kelway.cosmoalias.presentation.teams.TeamFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [RoomModule::class, DataModule::class, DomainModule::class]
)
interface AppComponent {
    fun inject(target: TeamFragment)
    fun inject(target: MainActivity)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun buildContext(context: Context): Builder
        fun build(): AppComponent
    }
}