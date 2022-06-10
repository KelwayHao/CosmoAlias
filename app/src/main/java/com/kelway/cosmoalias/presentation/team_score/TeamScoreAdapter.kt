package com.kelway.cosmoalias.presentation.team_score

import android.annotation.SuppressLint
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kelway.cosmoalias.domain.models.TeamScore

class TeamScoreAdapter() : RecyclerView.Adapter<TeamScoreViewHolder>() {
    private var items: List<TeamScore> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamScoreViewHolder {
        return TeamScoreViewHolder.newInstance(parent)
    }

    override fun onBindViewHolder(holder: TeamScoreViewHolder, position: Int) {
        holder.bindItem(items[position])
    }

    override fun getItemCount() = items.size

    @SuppressLint("NotifyDataSetChanged")
    fun submitItem(listItem: List<TeamScore>) {
        items = listItem
        notifyDataSetChanged()
    }
}