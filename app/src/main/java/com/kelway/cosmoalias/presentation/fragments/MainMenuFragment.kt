package com.kelway.cosmoalias.presentation.fragments

import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.kelway.cosmoalias.R
import com.kelway.cosmoalias.databinding.FragmentMainMenuBinding
import com.kelway.cosmoalias.presentation.CosmoAliasApplication
import com.kelway.cosmoalias.utils.preference.SharedPreferencesManager
import javax.inject.Inject

class MainMenuFragment : Fragment(R.layout.fragment_main_menu) {

    private val binding by viewBinding<FragmentMainMenuBinding>()

    @Inject
    lateinit var sharedPreferencesManager: SharedPreferencesManager

    override fun onStart() {
        super.onStart()
        CosmoAliasApplication.appComponent?.inject(this)
        binding.buttonInfo.setOnClickListener {
            findNavController().navigate(R.id.actionMainMenuFragmentToAboutAppFragment)
        }
        binding.buttonRules.setOnClickListener {
            findNavController().navigate(R.id.actionMainMenuFragmentToRulesFragment)
        }
        binding.buttonStartNewGame.setOnClickListener {
            sharedPreferencesManager.saveBoolean("loadDefaultValueTeam", true)

            findNavController().navigate(R.id.actionMainMenuFragmentToTeamFragment)

        }
        binding.buttonSetting.setOnClickListener {
            findNavController().navigate(R.id.actionMainMenuFragmentToSettingFragment)
        }
    }
}