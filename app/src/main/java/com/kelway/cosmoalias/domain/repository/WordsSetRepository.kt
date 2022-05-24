package com.kelway.cosmoalias.domain.repository

import com.kelway.cosmoalias.data.room.words_set_room.WordsSetEntity
import com.kelway.cosmoalias.domain.models.WordsSet
import kotlinx.coroutines.flow.Flow

interface WordsSetRepository {

    fun getAllWordsSet(): Flow<List<WordsSetEntity>>

    suspend fun saveWordsSet(wordsSet: WordsSet)

    suspend fun deleteWordsSet(wordsSet: WordsSet)
}