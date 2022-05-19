package com.kelway.cosmoalias.presentation.teams

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.kelway.cosmoalias.R
import com.kelway.cosmoalias.databinding.FragmentTeamBinding
import com.kelway.cosmoalias.presentation.CosmoAliasApplication
import com.kelway.cosmoalias.presentation.base.BaseAdapter
import com.kelway.cosmoalias.utils.dialogInputText
import javax.inject.Inject

class TeamFragment : Fragment(R.layout.fragment_team) {

    @Inject
    lateinit var viewModel: TeamViewModel

    private val binding by viewBinding<FragmentTeamBinding>()
    private val adapter by lazy { BaseAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        CosmoAliasApplication.appComponent?.inject(this)
        initView()
        initObserver()
        //testLoadTeamName()
    }

    private fun initView() {
        binding.recyclerNameTeam.adapter = adapter
        binding.buttonNextTeam.setOnClickListener {
            findNavController().navigate(R.id.actionTeamFragmentToWordSetsFragment)
        }
        binding.buttonEnterNewName.setOnClickListener {
            dialogInputText("", requireContext(), { inputText ->
                viewModel.createTeam(inputText.toString())
            }, {})
        }
    }

    private fun initObserver() {
        viewModel.team.observe(viewLifecycleOwner) { listObserver ->
            adapter.submitList(listObserver)
        }
    }

    /*private fun testLoadTeamName() {
        adapter.submitList(
            listOf(Team(1,"Альянс Республики", 0), Team(2,"Войска Империи", 0))
        )
    }*/
}
