package com.kelway.cosmoalias.domain.interactor.teamscore

import com.kelway.cosmoalias.domain.models.TeamScore

interface TeamScoreInteractor {
    suspend fun getAllTeamScore(): List<TeamScore>
    suspend fun updateTeamScore(teamScore: TeamScore)
}