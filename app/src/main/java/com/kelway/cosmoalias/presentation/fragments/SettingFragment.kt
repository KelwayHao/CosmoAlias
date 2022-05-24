package com.kelway.cosmoalias.presentation.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.kelway.cosmoalias.R
import com.kelway.cosmoalias.databinding.FragmentSettingBinding
import com.kelway.cosmoalias.presentation.CosmoAliasApplication
import com.kelway.cosmoalias.utils.preference.SharedPreferencesManager
import javax.inject.Inject

const val WORD_COUNT = "WORD_COUNT"
const val ROUND_LENGTH = "ROUND_LENGTH"
const val NUMBERS_LAPS = "NUMBERS_LAPS"

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
        binding.settingNumbersLaps.setText(sharedPreferencesManager.getPref(NUMBERS_LAPS, "4"))

        binding.buttonSaveSettings.setOnClickListener {
            sharedPreferencesManager.save(WORD_COUNT, binding.settingWordCount.text.toString())
            sharedPreferencesManager.save(ROUND_LENGTH, binding.settingRoundLength.text.toString())
            sharedPreferencesManager.save(NUMBERS_LAPS, binding.settingNumbersLaps.text.toString())
        }
    }
}