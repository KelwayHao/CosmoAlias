package com.kelway.cosmoalias.domain.models

import com.kelway.cosmoalias.presentation.StatusTeam

data class TeamScore(
    val id: Long,
    val nameTeam: String,
    var pointTeam: Int,
    var status: StatusTeam
)