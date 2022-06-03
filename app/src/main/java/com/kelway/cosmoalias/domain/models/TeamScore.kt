package com.kelway.cosmoalias.domain.models

data class TeamScore(
    val id: Long,
    val nameTeam: String,
    var pointTeam: Int,
    var status: Boolean
)