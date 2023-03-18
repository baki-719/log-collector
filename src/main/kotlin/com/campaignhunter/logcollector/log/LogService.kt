package com.campaignhunter.logcollector.log

import org.springframework.stereotype.Service

@Service
class LogService{

    suspend fun log(log: Log) {
        val fileName = log.appName

        val logWriter = LogWriter(fileName)
        logWriter.write(log.toText())
    }
}