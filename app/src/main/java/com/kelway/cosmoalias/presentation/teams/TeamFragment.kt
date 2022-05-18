package com.kelway.cosmoalias.presentation.teams
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.kelway.cosmoalias.CosmoAliasApplication
import com.kelway.cosmoalias.R
import com.kelway.cosmoalias.databinding.FragmentTeamBinding
import com.kelway.cosmoalias.domain.models.Team
import com.kelway.cosmoalias.presentation.base.BaseAdapter
import com.kelway.cosmoalias.utils.dialog
import javax.inject.Inject

class TeamFragment: Fragment(R.layout.fragment_team) {
    @Inject
    lateinit var teamViewModel: TeamViewModel
    private val binding by viewBinding<FragmentTeamBinding>()
    private val adapter by lazy { BaseAdapter() }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        CosmoAliasApplication.appComponent?.inject(this)
        binding.buttonNextTeam.setOnClickListener {
            findNavController().navigate(R.id.actionTeamFragmentToWordSetsFragment)
        }
        initView()
        initObserver()
        testLoadTeamName()
    }

    private fun initView() {
        binding.recyclerNameTeam.adapter = adapter
        binding.buttonEnterNewName.setOnClickListener {
            dialog("",requireContext(),{},{})
        }
    }

    private fun testLoadTeamName() {
        adapter.submitList(
            listOf(Team(1,"Альянс Республики", 0), Team(2,"Войска Империи", 0))
        )
    }

    private fun initObserver() {
        TODO("Not yet implemented")
    }
}
