package com.kelway.cosmoalias.data.room.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.kelway.cosmoalias.data.room.team_room.TeamDao
import com.kelway.cosmoalias.data.room.team_room.TeamEntity
import com.kelway.cosmoalias.data.room.words_set_room.WordsSetDao
import com.kelway.cosmoalias.data.room.words_set_room.WordsSetEntity

@Database(
    entities = [TeamEntity::class, WordsSetEntity::class],
    version = AppDatabase.VERSION_DB
)
abstract class AppDatabase : RoomDatabase() {
    companion object {
        const val VERSION_DB = 1
    }

    abstract fun getTeam(): TeamDao
    abstract fun getWordSets(): WordsSetDao
}