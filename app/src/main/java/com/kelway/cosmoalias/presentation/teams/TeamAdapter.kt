package com.kelway.cosmoalias.presentation.teams

import android.annotation.SuppressLint
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kelway.cosmoalias.domain.models.Team
import com.kelway.cosmoalias.presentation.listener.ListenerClickNameChanger

class TeamAdapter(private val clickNameChanger: ListenerClickNameChanger) :
    RecyclerView.Adapter<TeamViewHolder>() {
    private var items: List<Team> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {
        return TeamViewHolder.newInstance(parent, clickNameChanger)
    }

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        holder.bindItem(items[position])
    }

    override fun getItemCount() = items.size

    @SuppressLint("NotifyDataSetChanged")
    fun submitItem(listItem: List<Team>) {
        items = listItem
        notifyDataSetChanged()
    }
}