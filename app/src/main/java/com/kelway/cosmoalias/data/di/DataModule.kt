package com.kelway.cosmoalias.data.di

import com.kelway.cosmoalias.data.repository.TeamRepositoryImpl
import com.kelway.cosmoalias.data.room.team_room.TeamDao
import com.kelway.cosmoalias.domain.repository.TeamRepository
import dagger.Module
import dagger.Provides

@Module
class DataModule {

    @Provides
    fun providesTeamRepository(
        teamDao: TeamDao
    ): TeamRepository {
        return TeamRepositoryImpl(teamDao)
    }

}