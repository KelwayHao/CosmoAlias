package com.kelway.cosmoalias.presentation.fragments

import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.kelway.cosmoalias.R
import com.kelway.cosmoalias.databinding.FragmentSettingBinding

class SettingFragment: Fragment(R.layout.fragment_setting) {
    private val binding by viewBinding<FragmentSettingBinding>()

    override fun onStart() {
        super.onStart()
        initView()
    }

    private fun initView() {
        binding.buttonSaveSettings.setOnClickListener {

        }
    }
}