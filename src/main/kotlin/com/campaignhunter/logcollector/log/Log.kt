package com.campaignhunter.logcollector.log

import org.springframework.data.annotation.Id
import org.springframework.data.elasticsearch.annotations.Document

@Document(indexName = "logs")
data class Log(
    @Id
    val id: String?,
    val appName: String,
    val timestamp: String,
    val message: String,
    val level: String,
    val loggerName: String,
    val threadName: String
) {
    companion object {
        fun from(request: LogRequest):Log {
            return Log(
                id = null,
                appName = request.appName,
                timestamp = request.timestamp,
                message = request.message,
                level = request.level,
                loggerName = request.loggerName,
                threadName = request.threadName
            )
        }
    }
}