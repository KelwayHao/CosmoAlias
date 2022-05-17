package com.kelway.cosmoalias.data.repository

import com.kelway.cosmoalias.data.room.team_room.TeamDao
import com.kelway.cosmoalias.domain.models.Team
import com.kelway.cosmoalias.domain.repository.TeamRepository
import com.kelway.cosmoalias.utils.entityTeamToTeam
import com.kelway.cosmoalias.utils.teamToTeamEntity

class TeamRepositoryImpl(private val teamDao: TeamDao): TeamRepository {
    override suspend fun getAllTeam(): List<Team> {
        return teamDao.getAllTeamDao().map { teamEntity ->
            teamEntity.entityTeamToTeam()
        }
    }

    override suspend fun saveTeam(team: Team) {
        teamDao.saveTeamDao(teamEntity = team.teamToTeamEntity())
    }

    override suspend fun deleteTeam(team: Team) {
        teamDao.deleteTeamDao(teamEntity = team.teamToTeamEntity())
    }
}