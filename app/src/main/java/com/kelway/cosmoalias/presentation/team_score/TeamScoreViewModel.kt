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

    private val numberTeam get() = _team.value?.size ?: 0
    private val listTeam get() = _team

    init {
        loadTeam()
    }

    private fun loadTeam() {
        interactor.getAllTeamScore().map { listTeamScore ->
            /*val randomValue = (listTeamScore.indices).random()
            listTeamScore[randomValue].status = true
            updateTeamScore(listTeamScore[randomValue])*/
            _team.postValue(listTeamScore)
        }.launchIn(viewModelScope)
    }

    /*private fun teamRandom(): LiveData<List<TeamScore>> {
        val randomValue = (listTeam.value.).random()
        listTeam.value!![randomValue].status = true
        updateTeamScore(listTeam.value!![randomValue])
        return listTeam
    }*/

    private fun updateTeamScore(teamScore: TeamScore) {
        viewModelScope.launch {
            interactor.updateTeamScore(teamScore)
        }
    }
}