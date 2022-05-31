package com.kelway.cosmoalias.presentation.game_play

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kelway.cosmoalias.domain.interactor.teamscore.TeamScoreInteractor
import com.kelway.cosmoalias.domain.interactor.words_set.WordsSetInteractor
import com.kelway.cosmoalias.domain.models.WordsSet
import com.kelway.cosmoalias.utils.timer.TimerInteractor
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GamePlayViewModel @Inject constructor(
    private val interactorTeamScore: TeamScoreInteractor,
    private val interactorWordSet: WordsSetInteractor,
    private val timer: TimerInteractor
) : ViewModel() {

    private val _wordSets = MutableLiveData<List<WordsSet>>()
    val wordSets: LiveData<List<WordsSet>> get() = _wordSets

    private val _time = MutableLiveData<Long>()
    val time: LiveData<Long> get() = _time

    init {

    }

    fun loadWordSets(id: Long) {
        interactorWordSet.getAllWordsSet().map { listWordsSet ->
            val selectedSet = listWordsSet.filter { wordsSet ->
                wordsSet.id == id
            }
            _wordSets.postValue(selectedSet)
        }.launchIn(viewModelScope)
    }


    fun startTimer(delay: Long) {
        timer.startTimer(delay) {

        }
            .map { _time.postValue(it) }
            .launchIn(viewModelScope)

    }
}