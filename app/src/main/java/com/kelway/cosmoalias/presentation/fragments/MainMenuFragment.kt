package com.kelway.cosmoalias.presentation.fragments

import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.kelway.cosmoalias.R
import com.kelway.cosmoalias.databinding.FragmentMainMenuBinding

class MainMenuFragment: Fragment(R.layout.fragment_main_menu) {
    private val binding by viewBinding<FragmentMainMenuBinding>()

    override fun onStart() {
        super.onStart()
        binding.buttonInfo.setOnClickListener {
            findNavController().navigate(R.id.actionMainMenuFragmentToAboutAppFragment)
        }
        binding.buttonRules.setOnClickListener {
            findNavController().navigate(R.id.actionMainMenuFragmentToRulesFragment)
        }
        binding.buttonStartNewGame.setOnClickListener {
            findNavController().navigate(R.id.actionMainMenuFragmentToTeamFragment)
        }
    }
}