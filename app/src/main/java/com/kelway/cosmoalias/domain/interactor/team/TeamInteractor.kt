package com.kelway.cosmoalias.domain.interactor.team

import com.kelway.cosmoalias.domain.models.Team
import kotlinx.coroutines.flow.Flow

interface TeamInteractor {
    fun getAllTeam(): Flow<List<Team>>
    suspend fun createTeam(team: Team)
    suspend fun deleteTeam(team: Team)
    suspend fun clearTable()
}