package com.kelway.cosmoalias

import android.content.Context
import com.kelway.cosmoalias.data.di.DataModule
import com.kelway.cosmoalias.data.di.RoomModule
import com.kelway.cosmoalias.domain.di.DomainModule
import com.kelway.cosmoalias.presentation.MainActivity
import com.kelway.cosmoalias.presentation.addownset.AddOwnSetFragment
import com.kelway.cosmoalias.presentation.fragments.MainMenuFragment
import com.kelway.cosmoalias.presentation.fragments.SettingFragment
import com.kelway.cosmoalias.presentation.game_play.GamePlayFragment
import com.kelway.cosmoalias.presentation.result_game.ResultGameFragment
import com.kelway.cosmoalias.presentation.team_score.TeamScoreFragment
import com.kelway.cosmoalias.presentation.team_score.TeamScoreViewHolder
import com.kelway.cosmoalias.presentation.team_score.TeamScoreViewModel
import com.kelway.cosmoalias.presentation.teams.TeamFragment
import com.kelway.cosmoalias.presentation.wordset.WordSetsFragment
import com.kelway.cosmoalias.presentation.wordset.WordsSetViewHolder
import com.kelway.cosmoalias.utils.di.UtilsModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [RoomModule::class, DataModule::class, DomainModule::class, UtilsModule::class]
)
interface AppComponent {
    fun inject(target: TeamFragment)
    fun inject(target: MainActivity)
    fun inject(target: SettingFragment)
    fun inject(target: WordSetsFragment)
    fun inject(target: AddOwnSetFragment)
    fun inject(target: TeamScoreFragment)
    fun inject(target: GamePlayFragment)
    fun inject(target: WordsSetViewHolder)
    fun inject(target: MainMenuFragment)
    fun inject(target: TeamScoreViewHolder)
    fun inject(target: TeamScoreViewModel)
    fun inject(target: ResultGameFragment)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun buildContext(context: Context): Builder
        fun build(): AppComponent
    }
}