package com.kelway.cosmoalias.domain.models

data class TeamScore(
    val id: Long,
    val nameTeam: String,
    val pointTeam: Int,
    var status: Boolean
) : BaseItem()