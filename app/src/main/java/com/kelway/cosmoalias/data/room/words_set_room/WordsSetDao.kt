package com.kelway.cosmoalias.data.room.words_set_room

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface WordsSetDao {

    @Query("SELECT * FROM words_set")
    fun getAllWordSetsDao(): Flow<List<WordsSetEntity>>

    suspend fun saveWordsSetDao(wordSetEntity: WordsSetEntity)

    suspend fun deleteWordsSetDao(wordSetEntity: WordsSetEntity)

}