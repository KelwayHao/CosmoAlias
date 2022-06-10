package com.kelway.cosmoalias.utils.resource_provider

import android.content.Context
import javax.inject.Inject

class ResourceProviderImpl @Inject constructor(private val context: Context) : ResourceProvider {
    override fun getString(id: Int): String {
        return context.getString(id)
    }
}