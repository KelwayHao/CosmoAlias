package com.kelway.cosmoalias.presentation.wordset

import android.annotation.SuppressLint
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kelway.cosmoalias.domain.models.WordsSet

class WordSetsAdapter() : RecyclerView.Adapter<WordsSetViewHolder>() {
    private var items: List<WordsSet> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordsSetViewHolder {
        return WordsSetViewHolder.newInstance(parent)
    }

    override fun onBindViewHolder(holder: WordsSetViewHolder, position: Int) {
        holder.bindItem(items[position])
    }

    override fun getItemCount() = items.size

    @SuppressLint("NotifyDataSetChanged")
    fun submitItem(listItem: List<WordsSet>) {
        items = listItem
        notifyDataSetChanged()
    }
}