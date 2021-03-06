package com.kelway.cosmoalias.presentation.team_score

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kelway.cosmoalias.R
import com.kelway.cosmoalias.databinding.ItemTeamScoreBinding
import com.kelway.cosmoalias.domain.models.TeamScore
import com.kelway.cosmoalias.presentation.CosmoAliasApplication
import com.kelway.cosmoalias.utils.resource_provider.ResourceProvider
import javax.inject.Inject

class TeamScoreViewHolder @Inject constructor(private var binding: ItemTeamScoreBinding) :
    RecyclerView.ViewHolder(binding.root) {

    @Inject
    lateinit var resourceProvider: ResourceProvider

    companion object {
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

    fun bindItem(teamScore: TeamScore) {
        CosmoAliasApplication.appComponent?.inject(this)
        with(teamScore) {
            binding.nameItemTeamScore.text = nameTeam
            binding.scoreItemTeamScore.text = pointTeam.toString()
            binding.nameItemStatus.text = resourceProvider.getString(status.action)
        }
    }
}