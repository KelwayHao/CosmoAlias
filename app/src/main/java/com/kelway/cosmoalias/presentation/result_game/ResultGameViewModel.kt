package com.kelway.cosmoalias.presentation.result_game

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kelway.cosmoalias.domain.interactor.teamscore.TeamScoreInteractor
import com.kelway.cosmoalias.domain.models.TeamScore
import kotlinx.coroutines.launch
import javax.inject.Inject

class ResultGameViewModel @Inject constructor(private val interactor: TeamScoreInteractor): ViewModel() {

    private val _team = MutableLiveData<TeamScore>()
    val team: LiveData<TeamScore> get() = _team

    init {
        loadTeam()
    }

    private fun loadTeam() {
        viewModelScope.launch {
            _team.value = interactor.getAllTeamScore().maxByOrNull { teamScore ->
                teamScore.pointTeam
            }
        }
    }
}