package com.kelway.cosmoalias.data.repository

import com.kelway.cosmoalias.data.room.words_set_room.WordsSetDao
import com.kelway.cosmoalias.data.room.words_set_room.WordsSetEntity
import com.kelway.cosmoalias.domain.models.WordsSet
import com.kelway.cosmoalias.domain.repository.WordsSetRepository
import com.kelway.cosmoalias.utils.wordsSetToEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class WordsSetRepositoryImpl @Inject constructor(private val wordsSetDao: WordsSetDao) :
    WordsSetRepository {
    override fun getAllWordsSet(): Flow<List<WordsSetEntity>> {
        return wordsSetDao.getAllWordSetsDao()
    }

    override suspend fun saveWordsSet(wordsSet: WordsSet) {
        return withContext(Dispatchers.IO) {
            wordsSetDao.saveWordsSetDao(wordSetEntity = wordsSet.wordsSetToEntity())
        }
    }

    override suspend fun deleteWordsSet(wordsSet: WordsSet) {
        return withContext(Dispatchers.IO) {
            wordsSetDao.deleteWordsSetDao(wordSetEntity = wordsSet.wordsSetToEntity())
        }
    }
}