package com.kelway.cosmoalias.data.di

import android.content.Context
import androidx.room.Room
import com.kelway.cosmoalias.data.room.database.AppDatabase
import com.kelway.cosmoalias.data.room.team_room.TeamDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RoomModule {
    @Singleton
    @Provides
    fun provideAppDatabase(context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "cosmo_alias_database"
        ).build()
    }

    @Singleton
    @Provides
    fun provideTeamDao(database: AppDatabase): TeamDao {
        return database.getTeam()
    }

}