package com.kelway.cosmoalias.data.room.team_room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "list_team")
data class TeamEntity(
    @PrimaryKey
    var id: Long,
    @ColumnInfo(name = "name_team")
    val nameTeam: String,
    @ColumnInfo(name = "point_team")
    val pointTeam: Int
)
