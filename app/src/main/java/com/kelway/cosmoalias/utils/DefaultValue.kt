package com.kelway.cosmoalias.utils

import com.kelway.cosmoalias.R
import com.kelway.cosmoalias.domain.models.WordsSet

class DefaultValue {
    companion object {
        val FIRST_WORD_SET = WordsSet(0, "Базовый уровень", "Набор из оригинальной настольной игры. Содержит слова и словосочетания разной сложности.",
            listOf("крокодил", "рыба", "страус", "скелет"))
    }
}