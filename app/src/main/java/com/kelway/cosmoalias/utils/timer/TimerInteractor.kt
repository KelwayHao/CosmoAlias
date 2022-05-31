package com.kelway.cosmoalias.utils.timer

import kotlinx.coroutines.flow.Flow

interface TimerInteractor {
    fun startTimer(delay: Long, delayedAction: () -> Unit): Flow<Long>
}