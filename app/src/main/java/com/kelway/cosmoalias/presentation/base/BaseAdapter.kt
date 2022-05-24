package com.kelway.cosmoalias.presentation.base

import android.annotation.SuppressLint
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kelway.cosmoalias.domain.models.BaseItem
import com.kelway.cosmoalias.domain.models.Team
import com.kelway.cosmoalias.domain.models.WordsSet
import com.kelway.cosmoalias.presentation.teams.TeamViewHolder
import com.kelway.cosmoalias.presentation.wordset.WordsSetViewHolder

class BaseAdapter(): RecyclerView.Adapter<BaseViewHolder>() {

    private var items: List<BaseItem> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return when (viewType) {
            TeamViewHolder.VIEW_TYPE -> TeamViewHolder.newInstance(parent)
            WordsSetViewHolder.VIEW_TYPE -> WordsSetViewHolder.newInstance(parent)
            else -> throw IllegalStateException("Wrong view holder type")
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.bindItem(items[position])
    }

    override fun getItemViewType(position: Int): Int {
        return when (items[position]) {
            is Team -> TeamViewHolder.VIEW_TYPE
            is WordsSet -> WordsSetViewHolder.VIEW_TYPE
            else -> throw IllegalStateException("Wrong view view type")
        }
    }

    override fun getItemCount() = items.size

    @SuppressLint("NotifyDataSetChanged")
    fun submitList(data: List<BaseItem>) {
        items = data
        notifyDataSetChanged()
    }
}