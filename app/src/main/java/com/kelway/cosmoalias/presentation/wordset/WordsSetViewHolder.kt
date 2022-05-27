package com.kelway.cosmoalias.presentation.wordset

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.kelway.cosmoalias.R
import com.kelway.cosmoalias.databinding.ItemWordSetBinding
import com.kelway.cosmoalias.domain.models.BaseItem
import com.kelway.cosmoalias.domain.models.WordsSet
import com.kelway.cosmoalias.presentation.base.BaseViewHolder

class WordsSetViewHolder(private val binding: ItemWordSetBinding) : BaseViewHolder(binding.root) {

    companion object {
        const val VIEW_TYPE = 2
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

    override fun bindItem(baseItem: BaseItem) {
        (baseItem as WordsSet).apply {
            binding.titleWordSet.text = baseItem.title
            binding.textArticleWordSet.text = baseItem.article
            binding.textCountWordInSet.text = "${baseItem.listWords.size.toString()} слов"
            binding.buttonEnterWordSet.setOnClickListener {
                itemView.findNavController().navigate(R.id.actionWordSetsFragmentToTeamScoreFragment)
            }
        }
    }
}