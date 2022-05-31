package com.kelway.cosmoalias.domain.interactor.teamscore

import com.kelway.cosmoalias.domain.models.TeamScore
import kotlinx.coroutines.flow.Flow

interface TeamScoreInteractor {
    suspend fun getAllTeamScore(): List<TeamScore>
    suspend fun updateTeamScore(teamScore: TeamScore)
}