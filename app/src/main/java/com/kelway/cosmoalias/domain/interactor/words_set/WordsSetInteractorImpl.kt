package com.kelway.cosmoalias.domain.interactor.words_set

import com.kelway.cosmoalias.domain.models.WordsSet
import com.kelway.cosmoalias.domain.repository.WordsSetRepository
import com.kelway.cosmoalias.utils.wordsSetEntityToWordsSet
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class WordsSetInteractorImpl @Inject constructor(private val wordsSetRepository: WordsSetRepository) :
    WordsSetInteractor {
    override fun getAllWordsSet(): Flow<List<WordsSet>> {
        return wordsSetRepository.getAllWordsSet().map { listWordsSetEntity ->
            listWordsSetEntity.map { wordsSetEntity ->
                wordsSetEntity.wordsSetEntityToWordsSet()
            }
        }
    }

    override suspend fun saveWordsSet(wordsSet: WordsSet) {
        wordsSetRepository.saveWordsSet(wordsSet = wordsSet)
    }

    override suspend fun deleteWordsSet(wordsSet: WordsSet) {
        wordsSetRepository.deleteWordsSet(wordsSet = wordsSet)
    }

}