package com.kelway.cosmoalias.domain.interactor

import com.kelway.cosmoalias.domain.models.Team
import com.kelway.cosmoalias.domain.repository.TeamRepository

class TeamInteractorImpl(private val teamRepository: TeamRepository): TeamInteractor {
    override suspend fun getAllTeam(): List<Team> {
        return teamRepository.getAllTeam()
    }

    override suspend fun createTeam(team: Team) {
        teamRepository.saveTeam(team = team)
    }

    override suspend fun deleteTeam(team: Team) {
        teamRepository.deleteTeam(team = team)
    }
}