package com.kelway.cosmoalias.utils

class Constants {
    companion object {
        const val SELECTED_SET = "SELECTED_SET"

        const val WORD_COUNT = "WORD_COUNT"
        const val ROUND_LENGTH = "ROUND_LENGTH"
        const val NUMBERS_LAPS = "NUMBERS_LAPS"
        const val COUNT_LAPS = "COUNT_LAPS"

        const val REWARD_TRUE_ANSWER = 2
        const val PENALTY_FALSE_ANSWER = 1

        const val VALID_TEAM = """[\d|\w]{3,12}"""
        const val VALID_WORDS_SET = """[\d|\w]{5,20}"""
        const val VALID_COUNT_WORDS = """[5-9][\d]|[1-4][\d][\d]|[5][0][0]"""
        const val VALID_COUNT_ROUNDS = """[2-6]"""
        const val VALID_TIME_ROUND = """[1-9][\d]|[1][0-1][\d]|[1][2][0]"""
    }
}