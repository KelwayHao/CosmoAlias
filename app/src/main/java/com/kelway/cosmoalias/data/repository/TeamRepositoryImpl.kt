package com.kelway.cosmoalias.data.repository

import com.kelway.cosmoalias.data.room.team_room.TeamDao
import com.kelway.cosmoalias.data.room.team_room.TeamEntity
import com.kelway.cosmoalias.domain.models.Team
import com.kelway.cosmoalias.domain.repository.TeamRepository
import com.kelway.cosmoalias.utils.teamToTeamEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class TeamRepositoryImpl @Inject constructor(private val teamDao: TeamDao) : TeamRepository {

    override fun getAllTeam(): Flow<List<TeamEntity>> {
        return teamDao.getAllTeamDao()
    }

    override suspend fun saveTeam(team: Team) {
        return withContext(Dispatchers.IO) {
            teamDao.saveTeamDao(teamEntity = team.teamToTeamEntity())
        }
    }

    override suspend fun deleteTeam(team: Team) {
        return withContext(Dispatchers.IO) {
            teamDao.deleteTeamDao(teamEntity = team.teamToTeamEntity())
        }
    }

    override suspend fun clearTable() {
        return withContext(Dispatchers.IO) {
            teamDao.clearTable()
        }
    }
}