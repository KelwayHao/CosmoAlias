package com.kelway.cosmoalias.presentation.team_score

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.kelway.cosmoalias.R
import com.kelway.cosmoalias.databinding.FragmentTeamScoreBinding
import com.kelway.cosmoalias.presentation.CosmoAliasApplication
import com.kelway.cosmoalias.presentation.listener.ListenerEndRounds
import com.kelway.cosmoalias.utils.preference.SharedPreferencesManager
import com.kelway.cosmoalias.utils.showSnack
import javax.inject.Inject

class TeamScoreFragment : Fragment(R.layout.fragment_team_score) {

    @Inject
    lateinit var teamScoreViewModel: TeamScoreViewModel
    @Inject
    lateinit var sharedPreferencesManager: SharedPreferencesManager

    private val binding by viewBinding<FragmentTeamScoreBinding>()
    private val adapter by lazy { TeamScoreAdapter() }

    private val endRounds = object : ListenerEndRounds {
        override fun actionEndRounds() {
            sharedPreferencesManager.saveBoolean("continueGame", false)
            findNavController().navigate(R.id.actionTeamScoreFragmentToResultGameFragment)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        CosmoAliasApplication.appComponent?.inject(this)
        initView()
    }

    override fun onStart() {
        super.onStart()
        initObserver()
    }

    private fun initView() {
        binding.recyclerTeamScore.adapter = adapter
        sharedPreferencesManager.saveBoolean("continueGame", true)
        binding.buttonStartTeamScore.setOnClickListener {
            findNavController().navigate(R.id.actionTeamScoreFragmentToGamePlayFragment)
        }
    }

    private fun initObserver() {
        teamScoreViewModel.finishGame(endRounds)
        teamScoreViewModel.team.observe(viewLifecycleOwner) { listTeamScore ->
            adapter.submitItem(listTeamScore)
        }
    }
}