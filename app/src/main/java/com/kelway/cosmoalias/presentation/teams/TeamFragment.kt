package com.kelway.cosmoalias.presentation.teams

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.kelway.cosmoalias.R
import com.kelway.cosmoalias.databinding.FragmentTeamBinding
import com.kelway.cosmoalias.domain.models.Team
import com.kelway.cosmoalias.presentation.CosmoAliasApplication
import com.kelway.cosmoalias.presentation.listener.ListenerClickNameChanger
import com.kelway.cosmoalias.presentation.swipetodeletecallaback.SwipeToDeleteCallback
import com.kelway.cosmoalias.utils.DefaultDatabase
import com.kelway.cosmoalias.utils.dialogInputText
import com.kelway.cosmoalias.utils.dialogPermission
import com.kelway.cosmoalias.utils.preference.SharedPreferencesManager
import com.kelway.cosmoalias.utils.showSnack
import javax.inject.Inject

class TeamFragment : Fragment(R.layout.fragment_team) {

    @Inject
    lateinit var teamViewModel: TeamViewModel

    @Inject
    lateinit var sharedPreferencesManager: SharedPreferencesManager
    private val binding by viewBinding<FragmentTeamBinding>()
    private val adapter by lazy { TeamAdapter(clickNameChanger) }

    private val clickNameChanger = object : ListenerClickNameChanger {
        override fun actionClickNameChanger(team: Team) {
            dialogInputText(requireContext(), { inputText ->
                team.nameTeam = inputText.text.toString()
                teamViewModel.updateTeam(team)
                showSnack(getString(R.string.team_update_message), requireView())
            }, {})
        }
    }

    private val swipeToDeleteCallback = object : SwipeToDeleteCallback() {
        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            val position = viewHolder.absoluteAdapterPosition

            dialogPermission(
                getString(R.string.remove_permission_question),
                requireContext(),
                onPositiveButtonClick = {
                    teamViewModel.removeItem(position)?.let { team ->
                        teamViewModel.deleteTeam(team)
                    }
                    binding.recyclerNameTeam.adapter?.notifyItemRemoved(position)
                },
                onNegativeButtonClick = {
                    teamViewModel.loadTeam()
                }
            )
        }
    }

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
        val listRandomTeam = DefaultDatabase.LIST_RANDOM_NAME_TEAM.toMutableList()
        binding.recyclerNameTeam.adapter = adapter
        binding.buttonEnterNewName.setOnClickListener {
            if (teamViewModel.getSize() < 5) {
                dialogInputText(requireContext(), { inputText ->
                    showSnack(
                        getString(teamViewModel.createTeam(inputText.text.toString())),
                        requireView()
                    )
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

        binding.buttonRandomName.setOnClickListener {
            if (teamViewModel.getSize() < 5) {
                val teamRandom = listRandomTeam.random()
                listRandomTeam.remove(teamRandom)
                teamViewModel.createTeam(teamRandom)
            } else {
                showSnack(getString(R.string.rules_max_team), requireView())
            }
        }
    }

    private fun initObserver() {
        teamViewModel.team.observe(viewLifecycleOwner) { listObserver ->
            adapter.submitItem(listObserver)
        }

        ItemTouchHelper(swipeToDeleteCallback).attachToRecyclerView(binding.recyclerNameTeam)
    }

    private fun loadDefaultValue() {
        teamViewModel.defaultValue(DefaultDatabase.DEFAULT_TEAM)
    }
}
