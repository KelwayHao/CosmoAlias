package com.kelway.cosmoalias.presentation.game_play

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kelway.cosmoalias.domain.interactor.teamscore.TeamScoreInteractor
import com.kelway.cosmoalias.domain.interactor.words_set.WordsSetInteractor
import com.kelway.cosmoalias.domain.models.TeamScore
import com.kelway.cosmoalias.domain.models.WordsSet
import com.kelway.cosmoalias.presentation.StatusTeam
import com.kelway.cosmoalias.presentation.listener.ListenerTimerStopped
import com.kelway.cosmoalias.utils.timer.TimerInteractor
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

class GamePlayViewModel @Inject constructor(
    private val interactorTeamScore: TeamScoreInteractor,
    private val interactorWordSet: WordsSetInteractor,
    private val timer: TimerInteractor
) : ViewModel() {

    private val _team = MutableLiveData<TeamScore>()
    val team: LiveData<TeamScore> get() = _team

    private val _wordSets = MutableLiveData<List<WordsSet>>()
    val wordSets: LiveData<List<WordsSet>> get() = _wordSets

    private val _time = MutableLiveData<Long>()
    val time: LiveData<Long> get() = _time

    private lateinit var currentTeamScore: TeamScore

    init {
        loadTeam()
    }

    private fun loadTeam() {
        viewModelScope.launch {
            interactorTeamScore.getAllTeamScore().map { teamScore ->
                if (teamScore.status.action == StatusTeam.PLAYS.action) {
                    currentTeamScore = teamScore
                    _team.postValue(teamScore)
                }
            }
        }
    }

    fun updateTeamScore(point: Int) {
        viewModelScope.launch {
            interactorTeamScore.updateTeamScore(
                TeamScore(
                    id = currentTeamScore.id,
                    nameTeam = currentTeamScore.nameTeam,
                    pointTeam = point,
                    status = StatusTeam.PLAYED
                )
            )
        }
    }

    fun loadWordSets(id: Long) {
        interactorWordSet.getAllWordsSet().map { listWordsSet ->
            val selectedSet = listWordsSet.filter { wordsSet ->
                wordsSet.id == id
            }
            _wordSets.postValue(selectedSet)
        }.launchIn(viewModelScope)
    }


    fun startTimer(delay: Long, listenerTimerStopped: ListenerTimerStopped) {
        timer.startTimer(delay) {
            listenerTimerStopped.actionTimerStopped()
        }
            .map { _time.postValue(it) }
            .launchIn(viewModelScope)

    }
}