package com.kelway.cosmoalias.presentation.team_score

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.kelway.cosmoalias.R
import com.kelway.cosmoalias.databinding.FragmentTeamScoreBinding
import com.kelway.cosmoalias.presentation.CosmoAliasApplication
import com.kelway.cosmoalias.presentation.base.BaseAdapter
import javax.inject.Inject

class TeamScoreFragment : Fragment(R.layout.fragment_team_score) {

    @Inject
    lateinit var teamScoreViewModel: TeamScoreViewModel
    private val binding by viewBinding<FragmentTeamScoreBinding>()
    private val adapter by lazy { BaseAdapter() }

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
        binding.buttonStartTeamScore.setOnClickListener {
            findNavController().navigate(R.id.actionTeamScoreFragmentToGamePlayFragment)
        }
    }

    private fun initObserver() {
        teamScoreViewModel.team.observe(viewLifecycleOwner) { listTeamScore ->
            adapter.submitList(listTeamScore)
        }
    }
}