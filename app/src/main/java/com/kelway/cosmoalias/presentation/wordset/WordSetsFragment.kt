package com.kelway.cosmoalias.presentation.wordset

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.kelway.cosmoalias.R
import com.kelway.cosmoalias.databinding.FragmentWordSetsBinding
import com.kelway.cosmoalias.presentation.CosmoAliasApplication
import com.kelway.cosmoalias.presentation.swipetodeletecallaback.SwipeToDeleteCallback
import com.kelway.cosmoalias.utils.DefaultValue
import com.kelway.cosmoalias.utils.dialogPermission
import com.kelway.cosmoalias.utils.preference.SharedPreferencesManager
import javax.inject.Inject


class WordSetsFragment : Fragment(R.layout.fragment_word_sets) {

    @Inject
    lateinit var wordsSetViewModel: WordsSetViewModel

    @Inject
    lateinit var sharedPreferencesManager: SharedPreferencesManager

    private val binding by viewBinding<FragmentWordSetsBinding>()
    private val adapter by lazy { WordSetsAdapter() }

    private val swipeToDeleteCallback = object : SwipeToDeleteCallback() {
        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            val position = viewHolder.absoluteAdapterPosition

            dialogPermission(
                getString(R.string.remove_permission_question),
                requireContext(),
                onPositiveButtonClick = {
                    wordsSetViewModel.removeItem(position)?.let { wordsSet ->
                        wordsSetViewModel.deleteWordsSet(wordsSet)
                    }
                    binding.recyclerWordSets.adapter?.notifyItemRemoved(position)
                },
                onNegativeButtonClick = {
                    wordsSetViewModel.loadWordSets()
                }
            )
        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        CosmoAliasApplication.appComponent?.inject(this)
        binding.buttonAddNewWordSets.setOnClickListener {
            findNavController().navigate(R.id.actionWordSetsFragmentToAddOwnSetFragment)
        }
        if (sharedPreferencesManager.getBoolean("firstLoadDefaultValueWordSets", true)) {
            loadDefaultValue()
            sharedPreferencesManager.saveBoolean("firstLoadDefaultValueWordSets", false)
        }
        initView()
        initObserver()
    }

    private fun initView() {
        binding.recyclerWordSets.adapter = adapter
    }

    private fun initObserver() {
        wordsSetViewModel.wordSets.observe(viewLifecycleOwner) { listObserver ->
            adapter.submitItem(listObserver)
        }

        ItemTouchHelper(swipeToDeleteCallback).attachToRecyclerView(binding.recyclerWordSets)
    }

    private fun loadDefaultValue() {
        wordsSetViewModel.createWordsSet(DefaultValue.FIRST_WORD_SET)
    }
}