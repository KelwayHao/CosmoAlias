package com.kelway.cosmoalias.presentation.teams

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kelway.cosmoalias.R
import com.kelway.cosmoalias.databinding.ItemTeamBinding
import com.kelway.cosmoalias.domain.models.Team

class TeamViewHolder(private val binding: ItemTeamBinding) : RecyclerView.ViewHolder(binding.root) {

    companion object {
        fun newInstance(parent: ViewGroup) = TeamViewHolder(
            ItemTeamBinding.bind(
                LayoutInflater.from(parent.context)
                    .inflate(
                        R.layout.item_team,
                        parent,
                        false
                    )
            )
        )
    }

    fun bindItem(team: Team) {
        with(team) {
            binding.itemNameTeam.text = nameTeam
        }
    }
}