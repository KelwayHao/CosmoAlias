package com.kelway.cosmoalias.domain.interactor.teamscore

import com.kelway.cosmoalias.domain.models.TeamScore
import com.kelway.cosmoalias.domain.repository.TeamScoreRepository
import com.kelway.cosmoalias.utils.entityTeamToTeamScore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class TeamScoreInteractorImpl @Inject constructor(private val repository: TeamScoreRepository) :
    TeamScoreInteractor {
    override fun getAllTeamScore(): Flow<List<TeamScore>> {
        return repository.getAllTeamScore().map { listTeamEntity ->
            listTeamEntity.map { teamEntity ->
                teamEntity.entityTeamToTeamScore()
            }
        }
    }

    override suspend fun updateTeamScore(teamScore: TeamScore) {
        repository.updateTeamScore(teamScore)
    }

}