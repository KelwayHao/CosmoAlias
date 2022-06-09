package com.kelway.cosmoalias.presentation.listener

import com.kelway.cosmoalias.domain.models.Team

interface ListenerClickNameChanger {
    fun actionClickNameChanger(team: Team)
}