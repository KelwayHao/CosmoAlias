package com.kelway.cosmoalias

import android.app.Application

class CosmoAliasApplication: Application() {
    companion object {
        var appComponent: AppComponent? = null
    }

    override fun onCreate() {
        super.onCreate()
        initDagger()
    }

    private fun initDagger() {
        appComponent = DaggerAppComponent
            .builder()
            .buildContext(this)
            .build()
    }
}