package com.kelway.cosmoalias.presentation.team_score

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kelway.cosmoalias.domain.interactor.teamscore.TeamScoreInteractor
import com.kelway.cosmoalias.domain.models.TeamScore
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

class TeamScoreViewModel @Inject constructor(private val interactor: TeamScoreInteractor) :
    ViewModel() {
    private val _team = MutableLiveData<List<TeamScore>>()
    val team: LiveData<List<TeamScore>> get() = _team

    init {
        dataReset()
    }

    private fun dataReset() {
        viewModelScope.launch {
            interactor.getAllTeamScore().map { teamScore ->
                teamScore.status = false
                updateTeamScore(teamScore)
            }
        }.invokeOnCompletion {
            loadTeam()
        }
    }

    private fun loadTeam() {
        viewModelScope.launch {
            val listTeamScore = interactor.getAllTeamScore()
            val randomValue = (listTeamScore.indices).random()
            listTeamScore[randomValue].status = true
            updateTeamScore(listTeamScore[randomValue])
            _team.postValue(listTeamScore)
        }
    }

    private fun updateTeamScore(teamScore: TeamScore) {
        viewModelScope.launch {
            interactor.updateTeamScore(teamScore)
        }
    }
}