package com.kelway.cosmoalias.presentation.team_score

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kelway.cosmoalias.domain.interactor.teamscore.TeamScoreInteractor
import com.kelway.cosmoalias.domain.models.TeamScore
import com.kelway.cosmoalias.presentation.CosmoAliasApplication
import com.kelway.cosmoalias.presentation.StatusTeam
import com.kelway.cosmoalias.presentation.listener.ListenerEndRounds
import com.kelway.cosmoalias.utils.Constants
import com.kelway.cosmoalias.utils.preference.SharedPreferencesManager
import kotlinx.coroutines.launch
import javax.inject.Inject

class TeamScoreViewModel @Inject constructor(private val interactor: TeamScoreInteractor) :
    ViewModel() {

    @Inject
    lateinit var sharedPreferencesManager: SharedPreferencesManager

    private val _team = MutableLiveData<List<TeamScore>>()
    val team: LiveData<List<TeamScore>> get() = _team

    private lateinit var endGame: ListenerEndRounds

    init {
        loadTeam()
    }

    private fun dataReset() {
        viewModelScope.launch {
            interactor.getAllTeamScore().map { teamScore ->
                teamScore.status = StatusTeam.AWAITING
                updateTeamScore(teamScore).join()
            }
        }.invokeOnCompletion {
            loadTeam()
        }
    }

    private fun loadTeam() {
        CosmoAliasApplication.appComponent?.inject(this)
        val countLaps = sharedPreferencesManager.getInt(Constants.COUNT_LAPS, 1)
        val numberLapsGame = sharedPreferencesManager.getInt(Constants.NUMBERS_LAPS, 1)

        viewModelScope.launch {
            val listTeamScore = interactor.getAllTeamScore()
            val filterList = listTeamScore.filter { teamScore ->
                teamScore.status == StatusTeam.AWAITING
            }
            if (filterList.isEmpty()) {
                if (countLaps < numberLapsGame) {
                    sharedPreferencesManager.saveInt(Constants.COUNT_LAPS, countLaps + 1)
                    dataReset()
                } else {
                    endGame.actionEndRounds()
                }
            } else {
                filterList.first().status = StatusTeam.PLAYS
                updateTeamScore(filterList.first())
                Log.e("Список", listTeamScore.toString())
                _team.postValue(listTeamScore)
            }
        }
    }

    fun finishGame(listenerEndRounds: ListenerEndRounds) {
        endGame = listenerEndRounds
    }

    private suspend fun updateTeamScore(teamScore: TeamScore) = viewModelScope.launch {
        interactor.updateTeamScore(teamScore)
    }
}