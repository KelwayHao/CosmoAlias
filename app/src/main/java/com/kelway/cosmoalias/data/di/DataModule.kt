package com.kelway.cosmoalias.data.di

import com.kelway.cosmoalias.data.repository.TeamRepositoryImpl
import com.kelway.cosmoalias.data.repository.WordsSetRepositoryImpl
import com.kelway.cosmoalias.domain.repository.TeamRepository
import com.kelway.cosmoalias.domain.repository.WordsSetRepository
import dagger.Binds
import dagger.Module

@Module
interface DataModule {

    @Binds
    fun bindsTeamRepository(teamRepositoryImpl: TeamRepositoryImpl): TeamRepository

    @Binds
    fun bindsWordsSetRepository(wordsSetRepositoryImpl: WordsSetRepositoryImpl) : WordsSetRepository
}