package com.kelway.cosmoalias.domain.di

import com.kelway.cosmoalias.domain.interactor.team.TeamInteractor
import com.kelway.cosmoalias.domain.interactor.team.TeamInteractorImpl
import com.kelway.cosmoalias.domain.interactor.words_set.WordsSetInteractor
import com.kelway.cosmoalias.domain.interactor.words_set.WordsSetInteractorImpl
import dagger.Binds
import dagger.Module

@Module
interface DomainModule {

    @Binds
    fun bindsTeamInteractor(teamInteractorImpl: TeamInteractorImpl): TeamInteractor

    @Binds
    fun bindsWordsSetInteractor(wordsSetInteractorImpl: WordsSetInteractorImpl): WordsSetInteractor
}