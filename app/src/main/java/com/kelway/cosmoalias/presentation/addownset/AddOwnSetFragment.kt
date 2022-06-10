package com.kelway.cosmoalias.presentation.addownset

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.kelway.cosmoalias.R
import com.kelway.cosmoalias.databinding.FragmentAddOwnSetBinding
import com.kelway.cosmoalias.presentation.CosmoAliasApplication
import com.kelway.cosmoalias.utils.showSnack
import javax.inject.Inject

class AddOwnSetFragment : Fragment(R.layout.fragment_add_own_set) {

    @Inject
    lateinit var addSetViewModel: AddOwnSetViewModel
    private val binding by viewBinding<FragmentAddOwnSetBinding>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        CosmoAliasApplication.appComponent?.inject(this)
        initView()
    }

    private fun initView() {
        binding.addNewSet.setOnClickListener {
            addSetViewModel.createWordsSet(
                title = binding.fieldNameSet.text.toString(),
                article = binding.fieldDescription.text.toString(),
                listWords = binding.fieldWords.text.toString()
            ) { message, creationValidation ->
                if (creationValidation) {
                    showSnack(getString(message), requireView())
                    findNavController().navigate(R.id.actionAddOwnSetFragmentToWordSetsFragment)
                } else {
                    showSnack(getString(message), requireView())
                }
            }

        }
    }
}