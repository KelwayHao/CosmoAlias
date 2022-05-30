package com.kelway.cosmoalias.domain.repository

import com.kelway.cosmoalias.data.room.team_room.TeamEntity
import com.kelway.cosmoalias.domain.models.Team
import com.kelway.cosmoalias.domain.models.TeamScore
import kotlinx.coroutines.flow.Flow

interface TeamScoreRepository {
    fun getAllTeamScore(): Flow<List<TeamEntity>>

    suspend fun updateTeamScore(teamScore: TeamScore)
}