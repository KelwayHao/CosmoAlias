package com.kelway.cosmoalias.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import by.kirich1409.viewbindingdelegate.viewBinding
import com.kelway.cosmoalias.R
import com.kelway.cosmoalias.databinding.ActivityMainBinding
import com.kelway.cosmoalias.databinding.FragmentMainMenuBinding
import com.kelway.cosmoalias.presentation.fragments.MainMenuFragment

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    private val binding by viewBinding<ActivityMainBinding>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}