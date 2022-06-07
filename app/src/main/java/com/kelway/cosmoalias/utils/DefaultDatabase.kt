package com.kelway.cosmoalias.utils

import com.kelway.cosmoalias.domain.models.Team
import com.kelway.cosmoalias.domain.models.WordsSet

class DefaultDatabase {
    companion object {
        val FIRST_WORD_SET = WordsSet(0, "Базовый уровень", "Набор из оригинальной настольной игры. Содержит слова и словосочетания разной сложности.",
            listOf("крокодил", "рыба", "страус", "скелет", "петух", "попугай", "белка", "волк", "лисица"))

        val DEFAULT_TEAM = listOf(
            Team(0, "Alliance", 0),
            Team(1, "Imperial", 0)
        )
    }
}