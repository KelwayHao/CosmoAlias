package com.kelway.cosmoalias.utils

import com.kelway.cosmoalias.data.room.team_room.TeamEntity
import com.kelway.cosmoalias.domain.models.Team

fun TeamEntity.entityTeamToTeam() =
    Team(
        id = id,
        nameTeam = nameTeam,
        pointTeam = pointTeam
    )

fun Team.teamToTeamEntity() =
    TeamEntity(
        id = id,
        nameTeam = nameTeam,
        pointTeam = pointTeam
    )