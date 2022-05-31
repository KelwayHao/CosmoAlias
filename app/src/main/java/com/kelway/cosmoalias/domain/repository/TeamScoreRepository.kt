package com.kelway.cosmoalias.domain.repository

import com.kelway.cosmoalias.domain.models.TeamScore

interface TeamScoreRepository {
    suspend fun getAllTeamScore(): List<TeamScore>

    suspend fun updateTeamScore(teamScore: TeamScore)
}