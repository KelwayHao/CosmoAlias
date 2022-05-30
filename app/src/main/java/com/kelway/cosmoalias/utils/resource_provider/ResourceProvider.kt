package com.kelway.cosmoalias.utils.resource_provider

import androidx.annotation.StringRes

interface ResourceProvider {
    fun getString(@StringRes id: Int): String
}