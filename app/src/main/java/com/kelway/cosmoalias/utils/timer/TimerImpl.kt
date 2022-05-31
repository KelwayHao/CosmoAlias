package com.kelway.cosmoalias.utils.timer

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class TimerImpl @Inject constructor(): TimerInteractor {
    override fun startTimer(delay: Long, delayedAction: () -> Unit): Flow<Long> {
        return flow {
            var secondDelay = delay
            while (secondDelay >= 0L) {
                emit(secondDelay)
                delay(1000L)
                secondDelay--
                if (secondDelay == 0L) {
                    delayedAction()
                }
            }
        }
    }
}