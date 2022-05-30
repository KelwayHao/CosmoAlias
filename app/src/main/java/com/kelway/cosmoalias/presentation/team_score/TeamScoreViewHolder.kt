package com.kelway.cosmoalias.presentation.team_score

import android.view.LayoutInflater
import android.view.ViewGroup
import com.kelway.cosmoalias.R
import com.kelway.cosmoalias.databinding.ItemTeamScoreBinding
import com.kelway.cosmoalias.domain.models.BaseItem
import com.kelway.cosmoalias.domain.models.TeamScore
import com.kelway.cosmoalias.presentation.base.BaseViewHolder
import javax.inject.Inject

class TeamScoreViewHolder @Inject constructor(private var binding: ItemTeamScoreBinding) :
    BaseViewHolder(binding.root) {
    companion object {
        const val VIEW_TYPE = 3
        fun newInstance(parent: ViewGroup) = TeamScoreViewHolder(
            ItemTeamScoreBinding.bind(
                LayoutInflater.from(parent.context)
                    .inflate(
                        R.layout.item_team_score,
                        parent,
                        false
                    )
            )
        )
    }

    override fun bindItem(baseItem: BaseItem) {
        (baseItem as TeamScore).apply {
            binding.nameItemTeamScore.text = baseItem.nameTeam
            binding.scoreItemTeamScore.text = baseItem.pointTeam.toString()
            binding.nameItemStatus.text = if (baseItem.status) {
                binding.root.context.getString(R.string.plays_status)
            } else {
                binding.root.context.getString(R.string.waiting_status)
            }
        }
    }
}