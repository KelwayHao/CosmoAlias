package com.kelway.cosmoalias.presentation

import android.app.Application
import com.kelway.cosmoalias.AppComponent
import com.kelway.cosmoalias.DaggerAppComponent

class CosmoAliasApplication: Application() {
    companion object {
        var appComponent: AppComponent? = null
    }

    override fun onCreate() {
        super.onCreate()
        initDagger()
    }

    private fun initDagger() {
        appComponent = DaggerAppComponent.builder()
            .buildContext(this)
            .build()
    }
}