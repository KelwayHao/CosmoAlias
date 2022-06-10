package com.kelway.cosmoalias.domain.repository

import com.kelway.cosmoalias.data.room.team_room.TeamEntity
import com.kelway.cosmoalias.domain.models.Team
import kotlinx.coroutines.flow.Flow

interface TeamRepository {
    fun getAllTeam(): Flow<List<TeamEntity>>

    suspend fun saveTeam(team: Team)

    suspend fun deleteTeam(team: Team)

    suspend fun clearTable()

    suspend fun updateTeam(team: Team)
}