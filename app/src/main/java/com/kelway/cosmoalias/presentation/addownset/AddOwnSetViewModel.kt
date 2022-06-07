package com.kelway.cosmoalias.presentation.addownset

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kelway.cosmoalias.R
import com.kelway.cosmoalias.domain.interactor.words_set.WordsSetInteractor
import com.kelway.cosmoalias.domain.models.WordsSet
import com.kelway.cosmoalias.utils.isValidationTitleWordsSet
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

class AddOwnSetViewModel @Inject constructor(private val interactor: WordsSetInteractor) :
    ViewModel() {

    private val _setWords = MutableLiveData<List<WordsSet>>()
    val setWords: LiveData<List<WordsSet>> get() = _setWords

    private val numberSets get() = setWords.value?.size ?: 0

    init {
        loadSets()
    }

    private fun loadSets() {
        interactor.getAllWordsSet().map { listSets ->
            _setWords.postValue(listSets)
        }.launchIn(viewModelScope)
    }

    fun createWordsSet(
        title: String,
        article: String,
        listWords: String,
        action: (message: Int, creationValidation: Boolean) -> Unit
    ) {
        if (title.isNotEmpty() && title.isValidationTitleWordsSet() && article.isNotEmpty() && listWords.isNotEmpty()) {
            viewModelScope.launch {
                interactor.saveWordsSet(
                    WordsSet(
                        id = numberSets.toLong(),
                        title = title,
                        article = article,
                        listWords = listWords.split(", ")
                    )
                )
            }
            action(R.string.set_create_message, true)
        } else {
            action(R.string.set_error_message, false)
        }
    }
}