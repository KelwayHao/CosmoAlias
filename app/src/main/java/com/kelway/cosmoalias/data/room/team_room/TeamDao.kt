package com.kelway.cosmoalias.data.room.team_room

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface TeamDao {
    @Query("SELECT * FROM list_team")
    fun getAllTeamDao(): Flow<List<TeamEntity>>

    @Query("SELECT * FROM list_team")
    suspend fun getAllTeamDaoSuspend(): List<TeamEntity>

    @Insert
    suspend fun saveTeamDao(teamEntity: TeamEntity)

    @Delete
    suspend fun deleteTeamDao(teamEntity: TeamEntity)

    @Update
    suspend fun updateTeamDao(teamEntity: TeamEntity)

    @Query("DELETE FROM list_team")
    suspend fun clearTable()
}