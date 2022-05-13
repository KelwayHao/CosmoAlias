package com.kelway.cosmoalias.presentation.custom_splash_screen

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kelway.cosmoalias.presentation.MainActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class CustomSplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}