package com.kelway.cosmoalias.utils

import com.kelway.cosmoalias.data.room.team_room.TeamEntity
import com.kelway.cosmoalias.data.room.words_set_room.WordsSetEntity
import com.kelway.cosmoalias.domain.models.Team
import com.kelway.cosmoalias.domain.models.WordsSet

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

fun WordsSet.wordsSetToEntity() =
    WordsSetEntity(
        id = id,
        title = title,
        article = article,
        listWords = listWords.joinToString()
    )

fun WordsSetEntity.wordsSetEntityToWordsSet() =
    WordsSet(
        id = id,
        title = title,
        article = article,
        listWords = listWords.split(", ")
    )