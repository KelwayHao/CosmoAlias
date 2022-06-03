package com.kelway.cosmoalias.data.room.team_room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.kelway.cosmoalias.presentation.StatusTeam

@Entity(tableName = "list_team")
data class TeamEntity(
    @PrimaryKey
    var id: Long,
    @ColumnInfo(name = "name_team")
    val nameTeam: String,
    @ColumnInfo(name = "point_team")
    val pointTeam: Int,
    @ColumnInfo(name = "status_team")
    val statusTeam: StatusTeam = StatusTeam.AWAITING
)
