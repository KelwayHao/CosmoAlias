package com.kelway.cosmoalias.data.room.team_room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TeamDao {
    @Query("SELECT * FROM list_team")
    suspend fun getAllTeam(): List<TeamEntity>

    @Insert
    suspend fun saveTeam(teamEntity: TeamEntity)

    @Delete
    suspend fun deleteTeam(teamEntity: TeamEntity)
}