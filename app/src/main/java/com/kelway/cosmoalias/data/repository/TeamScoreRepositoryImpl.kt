package com.kelway.cosmoalias.data.repository

import com.kelway.cosmoalias.data.room.team_room.TeamDao
import com.kelway.cosmoalias.domain.models.TeamScore
import com.kelway.cosmoalias.domain.repository.TeamScoreRepository
import com.kelway.cosmoalias.utils.entityTeamToTeamScore
import com.kelway.cosmoalias.utils.teamScoreToTeamEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class TeamScoreRepositoryImpl @Inject constructor(private val teamDao: TeamDao) :
    TeamScoreRepository {

    override suspend fun getAllTeamScore(): List<TeamScore> {
        return withContext(Dispatchers.IO) {
            return@withContext teamDao.getAllTeamDaoSuspend().map { teamEntity ->
                teamEntity.entityTeamToTeamScore()
            }
        }
    }


    override suspend fun updateTeamScore(teamScore: TeamScore) {
        return withContext(Dispatchers.IO) {
            teamDao.updateTeamDao(teamScore.teamScoreToTeamEntity())
        }
    }
}