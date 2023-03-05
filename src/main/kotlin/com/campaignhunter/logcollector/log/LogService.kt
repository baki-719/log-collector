package com.campaignhunter.logcollector.log

import kotlinx.coroutines.reactor.awaitSingle
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux

@Service
class LogService(
    private val reactiveLogRepository: ReactiveLogRepository
) {

    suspend fun log(log: Log): Log {
        return reactiveLogRepository.save(log).awaitSingle()
    }

    suspend fun getTest(): Flux<Log> {
        return reactiveLogRepository.findAll()
    }

    fun delete() {
        reactiveLogRepository.deleteAll()
    }
}