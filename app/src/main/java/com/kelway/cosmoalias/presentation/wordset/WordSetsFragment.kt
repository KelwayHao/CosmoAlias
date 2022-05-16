package com.kelway.cosmoalias.presentation.wordset

import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.kelway.cosmoalias.R
import com.kelway.cosmoalias.databinding.FragmentWordSetsBinding

class WordSetsFragment : Fragment(R.layout.fragment_word_sets) {
    private val binding by viewBinding<FragmentWordSetsBinding>()

    override fun onStart() {
        super.onStart()
        binding.buttonAddNewWordSets.setOnClickListener {
            findNavController().navigate(R.id.actionWordSetsFragmentToAddOwnSetFragment)
        }
    }
}