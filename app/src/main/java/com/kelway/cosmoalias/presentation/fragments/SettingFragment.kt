package com.kelway.cosmoalias.presentation.fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.kelway.cosmoalias.R
import com.kelway.cosmoalias.databinding.FragmentSettingBinding
import com.kelway.cosmoalias.presentation.CosmoAliasApplication
import com.kelway.cosmoalias.utils.Constants.Companion.NUMBERS_LAPS
import com.kelway.cosmoalias.utils.Constants.Companion.ROUND_LENGTH
import com.kelway.cosmoalias.utils.Constants.Companion.WORD_COUNT
import com.kelway.cosmoalias.utils.isValidationCountRounds
import com.kelway.cosmoalias.utils.isValidationCountWords
import com.kelway.cosmoalias.utils.isValidationTimeRound
import com.kelway.cosmoalias.utils.preference.SharedPreferencesManager
import com.kelway.cosmoalias.utils.showSnack
import javax.inject.Inject

class SettingFragment : Fragment(R.layout.fragment_setting) {
    private val binding by viewBinding<FragmentSettingBinding>()

    @Inject
    lateinit var sharedPreferencesManager: SharedPreferencesManager

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        CosmoAliasApplication.appComponent?.inject(this)
        initView()
    }

    private fun initView() {
        binding.settingWordCount.setText(sharedPreferencesManager.getPref(WORD_COUNT, "120"))
        binding.settingRoundLength.setText(sharedPreferencesManager.getPref(ROUND_LENGTH, "60"))
        binding.settingNumbersLaps.setText(
            sharedPreferencesManager.getInt(NUMBERS_LAPS, 4).toString()
        )

        binding.buttonSaveSettings.setOnClickListener {
            if (
                binding.settingWordCount.text.toString().isValidationCountWords() &&
                binding.settingRoundLength.text.toString().isValidationTimeRound() &&
                binding.settingNumbersLaps.text.toString().isValidationCountRounds()
            ) {
                sharedPreferencesManager.save(
                    WORD_COUNT,
                    binding.settingWordCount.text.toString()
                )
                sharedPreferencesManager.save(
                    ROUND_LENGTH,
                    binding.settingRoundLength.text.toString()
                )
                sharedPreferencesManager.saveInt(
                    NUMBERS_LAPS,
                    binding.settingNumbersLaps.text.toString().toInt()
                )
                showSnack(getString(R.string.setting_save), requireView())
            } else {
                showSnack(getString(R.string.error_message_setting), requireView())
            }
        }
    }
}