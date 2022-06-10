package com.kelway.cosmoalias.domain.interactor.teamscore

import com.kelway.cosmoalias.domain.models.TeamScore
import com.kelway.cosmoalias.domain.repository.TeamScoreRepository
import javax.inject.Inject

class TeamScoreInteractorImpl @Inject constructor(private val repository: TeamScoreRepository) :
    TeamScoreInteractor {
    override suspend fun getAllTeamScore(): List<TeamScore> {
        return repository.getAllTeamScore()
    }


    override suspend fun updateTeamScore(teamScore: TeamScore) {
        repository.updateTeamScore(teamScore)
    }

}