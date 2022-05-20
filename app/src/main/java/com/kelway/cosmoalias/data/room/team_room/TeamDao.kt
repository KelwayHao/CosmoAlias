package com.kelway.cosmoalias.data.room.team_room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface TeamDao {
    @Query("SELECT * FROM list_team")
    fun getAllTeamDao(): Flow<List<TeamEntity>>

    @Insert
    suspend fun saveTeamDao(teamEntity: TeamEntity)

    @Delete
    suspend fun deleteTeamDao(teamEntity: TeamEntity)

    @Query("DELETE FROM list_team")
    suspend fun clearTable()
}