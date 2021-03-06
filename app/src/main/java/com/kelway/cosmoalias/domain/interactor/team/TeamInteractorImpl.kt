package com.kelway.cosmoalias.domain.interactor.team

import com.kelway.cosmoalias.domain.models.Team
import com.kelway.cosmoalias.domain.repository.TeamRepository
import com.kelway.cosmoalias.utils.entityTeamToTeam
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class TeamInteractorImpl @Inject constructor(private val teamRepository: TeamRepository) :
    TeamInteractor {
    override fun getAllTeam(): Flow<List<Team>> {
        return teamRepository.getAllTeam().map { listTeamEntity ->
            listTeamEntity.map { teamEntity ->
                teamEntity.entityTeamToTeam()
            }
        }
    }

    override suspend fun createTeam(team: Team) {
        teamRepository.saveTeam(team = team)
    }

    override suspend fun deleteTeam(team: Team) {
        teamRepository.deleteTeam(team = team)
    }

    override suspend fun clearTable() {
        teamRepository.clearTable()
    }

    override suspend fun updateTeam(team: Team) {
        teamRepository.updateTeam(team)
    }
}