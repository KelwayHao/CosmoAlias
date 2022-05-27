package com.kelway.cosmoalias.data.room.words_set_room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface WordsSetDao {

    @Query("SELECT * FROM words_set")
    fun getAllWordSetsDao(): Flow<List<WordsSetEntity>>
    @Insert
    suspend fun saveWordsSetDao(wordSetEntity: WordsSetEntity)
    @Delete
    suspend fun deleteWordsSetDao(wordSetEntity: WordsSetEntity)

}