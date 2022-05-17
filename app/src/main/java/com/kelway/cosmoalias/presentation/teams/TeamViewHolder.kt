package com.kelway.cosmoalias.presentation.teams

import android.view.LayoutInflater
import android.view.ViewGroup
import com.kelway.cosmoalias.R
import com.kelway.cosmoalias.databinding.ItemTeamBinding
import com.kelway.cosmoalias.domain.models.BaseItem
import com.kelway.cosmoalias.domain.models.Team
import com.kelway.cosmoalias.presentation.base.BaseViewHolder

class TeamViewHolder(private val binding: ItemTeamBinding) : BaseViewHolder(binding.root) {
    companion object {
        const val VIEW_TYPE = 1
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

    override fun bindItem(baseItem: BaseItem) {
        (baseItem as Team).apply {
            binding.itemNameTeam.text = baseItem.nameTeam
        }
    }
}