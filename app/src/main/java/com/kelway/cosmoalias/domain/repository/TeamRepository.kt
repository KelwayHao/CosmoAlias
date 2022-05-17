package com.kelway.cosmoalias.domain.repository

import com.kelway.cosmoalias.domain.models.Team

interface TeamRepository {
    suspend fun getAllTeam(): List<Team>

    suspend fun saveTeam(team: Team)

    suspend fun deleteTeam(team: Team)
}