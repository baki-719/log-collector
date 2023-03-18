package com.campaignhunter.logcollector.log

data class Log(
    val appName: String,
    val timestamp: String,
    val message: String,
    val level: String,
    val loggerName: String,
    val threadName: String
) {

    fun toText(): String {
        return "$timestamp $threadName $loggerName $level $message"
    }

    companion object {
        fun from(request: LogRequest):Log {
            return Log(
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