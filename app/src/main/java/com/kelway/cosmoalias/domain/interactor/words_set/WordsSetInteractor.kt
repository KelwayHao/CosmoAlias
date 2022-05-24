package com.kelway.cosmoalias.domain.interactor.words_set

import com.kelway.cosmoalias.domain.models.WordsSet
import kotlinx.coroutines.flow.Flow

interface WordsSetInteractor {
    fun getAllWordsSet(): Flow<List<WordsSet>>

    suspend fun saveWordsSet(wordsSet: WordsSet)

    suspend fun deleteWordsSet(wordsSet: WordsSet)
}