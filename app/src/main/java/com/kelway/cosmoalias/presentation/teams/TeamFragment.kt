package com.kelway.cosmoalias.presentation.teams
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.kelway.cosmoalias.R
import com.kelway.cosmoalias.databinding.FragmentTeamBinding
import com.kelway.cosmoalias.domain.models.Team
import com.kelway.cosmoalias.presentation.base.BaseAdapter

class TeamFragment: Fragment(R.layout.fragment_team) {
    private val binding by viewBinding<FragmentTeamBinding>()
    private val adapter by lazy { BaseAdapter() }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonNextTeam.setOnClickListener {
            findNavController().navigate(R.id.actionTeamFragmentToWordSetsFragment)
        }
        initView()
        testLoadTeamName()
    }

    private fun initView() {
        binding.recyclerNameTeam.adapter = adapter
    }

    private fun testLoadTeamName() {
        adapter.submitList(
            listOf(Team("Альянс Республики", 0), Team("Войска Империи", 0))
        )
    }
}
