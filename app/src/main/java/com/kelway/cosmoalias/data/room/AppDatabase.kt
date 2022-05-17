package com.kelway.cosmoalias.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.kelway.cosmoalias.data.room.team_room.TeamDao
import com.kelway.cosmoalias.data.room.team_room.TeamEntity

@Database(entities = [TeamEntity::class], version = AppDatabase.VERSION_DB)
abstract class AppDatabase : RoomDatabase() {
    companion object {
        const val VERSION_DB = 1
    }

    abstract fun getTeam(): TeamDao
}