package com.kelway.cosmoalias.domain.di

import com.kelway.cosmoalias.domain.interactor.TeamInteractor
import com.kelway.cosmoalias.domain.interactor.TeamInteractorImpl
import com.kelway.cosmoalias.domain.repository.TeamRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
class DomainModule {

    @Provides
    fun providesTeamInteractor(
        teamRepository: TeamRepository
    ): TeamInteractor {
        return TeamInteractorImpl(teamRepository)
    }
   /* @Binds
    fun bindsTeamInteractor(teamInteractorImpl: TeamInteractorImpl): TeamInteractor*/
}