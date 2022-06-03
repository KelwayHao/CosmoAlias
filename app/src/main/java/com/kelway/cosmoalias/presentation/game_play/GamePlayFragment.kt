package com.kelway.cosmoalias.presentation.game_play

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.kelway.cosmoalias.R
import com.kelway.cosmoalias.databinding.FragmentGamePlayBinding
import com.kelway.cosmoalias.presentation.CosmoAliasApplication
import com.kelway.cosmoalias.presentation.listener.ListenerTimerStopped
import com.kelway.cosmoalias.utils.Constants
import com.kelway.cosmoalias.utils.preference.SharedPreferencesManager
import javax.inject.Inject

class GamePlayFragment : Fragment(R.layout.fragment_game_play) {

    @Inject
    lateinit var gamePlayViewModel: GamePlayViewModel

    @Inject
    lateinit var sharedPreferencesManager: SharedPreferencesManager
    private val binding by viewBinding<FragmentGamePlayBinding>()

    private var point: Int = 0

    private val timerStopped = object : ListenerTimerStopped {
        override fun actionTimerStopped() {
            gamePlayViewModel.updateTeamScore(point)
            requireActivity().onBackPressed()

        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        CosmoAliasApplication.appComponent?.inject(this)
        val timeRound = sharedPreferencesManager.getPref(Constants.ROUND_LENGTH, "60")
        binding.textViewHeadTitleTimeRound.text = getString(R.string.seconds_left, timeRound)
        binding.buttonStartPlayGame.setOnClickListener {
            binding.buttonStartPlayGame.visibility = View.INVISIBLE
            binding.buttonNegativeAnswer.visibility = View.VISIBLE
            binding.buttonPositiveAnswer.visibility = View.VISIBLE
            startGame(timeRound)
        }
    }

    private fun startGame(timeRound: String) {
        gamePlayViewModel.team.observe(viewLifecycleOwner) { teamScore ->
            point = teamScore.pointTeam
        }
        gamePlayViewModel.loadWordSets(
            sharedPreferencesManager.getPref(Constants.SELECTED_SET, "0").toLong()
        )
        gamePlayViewModel.startTimer(timeRound.toLong(), timerStopped)
        gamePlayViewModel.wordSets.observe(viewLifecycleOwner) { listWordsSet ->
            displayWord(listWordsSet.first().listWords)

            binding.buttonNegativeAnswer.setOnClickListener {
                negativeAnswer(listWordsSet.first().listWords)
            }

            binding.buttonPositiveAnswer.setOnClickListener {
                positiveAnswer(listWordsSet.first().listWords)
            }
        }
        gamePlayViewModel.time.observe(viewLifecycleOwner) {
            val second = gamePlayViewModel.time.value.toString()
            binding.textViewHeadTitleTimeRound.text = getString(R.string.seconds_left, second)
        }
    }


    private fun displayWord(listWord: List<String>) {
        binding.fieldGameWord.text = listWord.random()
    }

    private fun positiveAnswer(listWord: List<String>) {
        point += Constants.REWARD_TRUE_ANSWER
        displayWord(listWord)
    }

    private fun negativeAnswer(listWord: List<String>) {
        point -= Constants.PENALTY_FALSE_ANSWER
        displayWord(listWord)
    }
}