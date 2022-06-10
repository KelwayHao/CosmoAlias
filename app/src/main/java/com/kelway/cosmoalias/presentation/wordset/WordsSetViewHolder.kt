package com.kelway.cosmoalias.presentation.wordset

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.kelway.cosmoalias.R
import com.kelway.cosmoalias.databinding.ItemWordSetBinding
import com.kelway.cosmoalias.domain.models.WordsSet
import com.kelway.cosmoalias.presentation.CosmoAliasApplication
import com.kelway.cosmoalias.utils.Constants
import com.kelway.cosmoalias.utils.preference.SharedPreferencesManager
import com.kelway.cosmoalias.utils.resource_provider.ResourceProvider
import javax.inject.Inject

class WordsSetViewHolder(private val binding: ItemWordSetBinding) :
    RecyclerView.ViewHolder(binding.root) {
    @Inject
    lateinit var sharedPreferencesManager: SharedPreferencesManager
    @Inject
    lateinit var resourceProvider: ResourceProvider
    companion object {
        fun newInstance(parent: ViewGroup) = WordsSetViewHolder(
            ItemWordSetBinding.bind(
                LayoutInflater.from(parent.context)
                    .inflate(
                        R.layout.item_word_set,
                        parent,
                        false
                    )
            )
        )
    }

    fun bindItem(wordsSet: WordsSet) {
        CosmoAliasApplication.appComponent?.inject(this)
        with(wordsSet) {
            binding.titleWordSet.text = title
            binding.textArticleWordSet.text = article
            binding.textCountWordInSet.text = resourceProvider.getString(R.string.count_word, listWords.size.toString())
            binding.buttonEnterWordSet.setOnClickListener {
                sharedPreferencesManager.save(Constants.SELECTED_SET, id.toString())
                sharedPreferencesManager.saveInt(Constants.COUNT_LAPS, 1)
                itemView.findNavController()
                    .navigate(R.id.actionWordSetsFragmentToTeamScoreFragment)
            }
        }
    }
}