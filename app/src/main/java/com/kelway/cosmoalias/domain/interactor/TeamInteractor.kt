package com.kelway.cosmoalias.domain.interactor

import com.kelway.cosmoalias.domain.models.Team

interface TeamInteractor {
    suspend fun getAllTeam(): List<Team>
    suspend fun createTeam(team: Team)
    suspend fun deleteTeam(team: Team)
}