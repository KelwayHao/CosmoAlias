package com.kelway.cosmoalias.presentation.teams

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kelway.cosmoalias.R
import com.kelway.cosmoalias.domain.interactor.team.TeamInteractor
import com.kelway.cosmoalias.domain.models.Team
import com.kelway.cosmoalias.utils.isValidationTeam
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

class TeamViewModel @Inject constructor(
    private val interactor: TeamInteractor
) : ViewModel() {

    private val _team = MutableLiveData<List<Team>>()
    val team: LiveData<List<Team>> get() = _team
    private val sizeList get() = team.value?.size ?: 0
    private val listNameTeam: List<String>
        get() = team.value?.map { team ->
            team.nameTeam
        } ?: listOf()

    init {
        loadTeam()
    }

    fun loadTeam() {
        interactor.getAllTeam()
            .map { listTeam ->
                _team.postValue(listTeam)
            }
            .launchIn(viewModelScope)
    }

    fun createTeam(nameTeam: String): Int {
        return if (!listNameTeam.contains(nameTeam)) {
            return if (nameTeam.isValidationTeam()) {
                viewModelScope.launch {
                    interactor.createTeam(
                        Team(
                            id = nameTeam.hashCode().toLong(),
                            nameTeam = nameTeam,
                            pointTeam = 0
                        )
                    )
                }
                R.string.team_created_message
            } else {
                R.string.restrictions_input
            }
        } else {
            R.string.error_message_duplicate_team
        }
    }

    fun deleteTeam(team: Team) {
        viewModelScope.launch {
            interactor.deleteTeam(team = team)
        }.invokeOnCompletion {
            loadTeam()
        }
    }

    fun defaultValue(list: List<Team>) {
        list.map { team ->
            createTeam(team.nameTeam)
        }
    }

    fun clearTable() {
        viewModelScope.launch {
            interactor.clearTable()
        }
    }

    fun getSize(): Int {
        return sizeList
    }

    fun removeItem(position: Int): Team? {
        return _team.value?.toMutableList()?.removeAt(position)
    }

    fun updateTeam(team: Team) {
        viewModelScope.launch {
            interactor.updateTeam(team)
        }.invokeOnCompletion {
            loadTeam()
        }
    }
}