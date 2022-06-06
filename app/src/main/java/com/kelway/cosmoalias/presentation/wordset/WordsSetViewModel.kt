package com.kelway.cosmoalias.presentation.wordset

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kelway.cosmoalias.domain.interactor.words_set.WordsSetInteractor
import com.kelway.cosmoalias.domain.models.WordsSet
import com.kelway.cosmoalias.utils.DefaultValue
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

class WordsSetViewModel @Inject constructor(private val interactor: WordsSetInteractor) :
    ViewModel() {

    private val _wordSets = MutableLiveData<List<WordsSet>>()
    val wordSets: LiveData<List<WordsSet>> get() = _wordSets

    private val sizeList get() = wordSets.value?.size ?: 0

    init {
        loadWordSets()
    }

    fun loadWordSets() {
        interactor.getAllWordsSet()
            .map { listWordsSet ->
                _wordSets.postValue(listWordsSet)
            }
            .launchIn(viewModelScope)
    }

    fun createWordsSet(wordsSet: WordsSet) {
        viewModelScope.launch {
            interactor.saveWordsSet(wordsSet)
        }
    }

    fun deleteWordsSet(wordsSet: WordsSet) {
        viewModelScope.launch {
            interactor.deleteWordsSet(wordsSet)
        }.invokeOnCompletion {
            loadWordSets()
        }
    }

    fun removeItem(position: Int): WordsSet? {
        return _wordSets.value?.toMutableList()?.removeAt(position)
    }
}