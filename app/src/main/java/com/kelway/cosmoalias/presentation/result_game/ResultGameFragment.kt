package com.kelway.cosmoalias.presentation.result_game

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.kelway.cosmoalias.R
import com.kelway.cosmoalias.databinding.FragmentResultGameBinding
import com.kelway.cosmoalias.domain.models.TeamScore
import com.kelway.cosmoalias.presentation.CosmoAliasApplication
import javax.inject.Inject

class ResultGameFragment : Fragment(R.layout.fragment_result_game) {

    @Inject
    lateinit var resultGameViewModel: ResultGameViewModel

    private val binding by viewBinding<FragmentResultGameBinding>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        CosmoAliasApplication.appComponent?.inject(this)
        initObserver()
        initView()
    }

    private fun initView() {
        binding.buttonEndGame.setOnClickListener {
            findNavController().navigate(R.id.actionResultGameFragmentToMainMenuFragment)
        }
    }

    private fun initObserver() {
        resultGameViewModel.team.observe(viewLifecycleOwner) { teamScore ->
            with(binding) {
                teamWinner.text = teamScore.nameTeam
                teamWinnerPoint.text = teamScore.pointTeam.toString()
                shareWinnerMoment.setOnClickListener {
                    openIntent(teamScore)
                }
            }
        }
    }

    private fun openIntent(teamScore: TeamScore) {
        val intent = Intent(Intent.ACTION_SEND).apply {
            type = "text/plain"
            putExtra(Intent.EXTRA_TEXT, getString(R.string.message_for_share, teamScore.nameTeam, teamScore.pointTeam))
        }

        val intentChooser = Intent.createChooser(intent, getString(R.string.share_your_achievement))
        startActivity(intentChooser)
    }
}