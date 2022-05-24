package com.kelway.cosmoalias.domain.models

data class WordsSet(
    val id: Long,
    val title: String,
    val article: String,
    val listWords: String
) : BaseItem()
