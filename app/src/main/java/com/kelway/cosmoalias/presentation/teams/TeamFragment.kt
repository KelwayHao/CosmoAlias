package com.kelway.cosmoalias.presentation.teams

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.kelway.cosmoalias.R
import com.kelway.cosmoalias.databinding.FragmentTeamBinding
import com.kelway.cosmoalias.presentation.CosmoAliasApplication
import com.kelway.cosmoalias.utils.DefaultValue
import com.kelway.cosmoalias.utils.dialogInputText
import com.kelway.cosmoalias.utils.preference.SharedPreferencesManager
import com.kelway.cosmoalias.utils.showSnack
import javax.inject.Inject

class TeamFragment : Fragment(R.layout.fragment_team) {

    @Inject
    lateinit var teamViewModel: TeamViewModel

    @Inject
    lateinit var sharedPreferencesManager: SharedPreferencesManager
    private val binding by viewBinding<FragmentTeamBinding>()
    private val adapter by lazy { TeamAdapter() }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        CosmoAliasApplication.appComponent?.inject(this)
        teamViewModel.clearTable()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (sharedPreferencesManager.getBoolean("loadDefaultValueTeam", true)) {
            loadDefaultValue()
            sharedPreferencesManager.saveBoolean("loadDefaultValueTeam", false)
        }
        initView()
        initObserver()
    }

    private fun initView() {
        binding.recyclerNameTeam.adapter = adapter
        binding.buttonEnterNewName.setOnClickListener {
            if (teamViewModel.getSize() < 5) {
                dialogInputText(requireContext(), { inputText ->
                    teamViewModel.createTeam(inputText.text.toString())
                }, {})
            } else {
                showSnack(getString(R.string.rules_max_team), requireView())
            }
        }
        binding.buttonNextTeam.setOnClickListener {
            if (teamViewModel.getSize() >= 2) {
                findNavController().navigate(R.id.actionTeamFragmentToWordSetsFragment)
            } else {
                showSnack(getString(R.string.rules_min_team), requireView())
            }
        }
    }

    private fun initObserver() {
        teamViewModel.team.observe(viewLifecycleOwner) { listObserver ->
            adapter.submitItem(listObserver)
        }
    }

    private fun loadDefaultValue() {
        teamViewModel.defaultValue(DefaultValue.DEFAULT_TEAM)
    }
}
