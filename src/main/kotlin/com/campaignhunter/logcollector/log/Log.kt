package com.campaignhunter.logcollector.log

data class Log(
    val appName: String,
    val timestamp: String,
    val message: String,
    val level: String,
    val loggerName: String,
    val threadName: String
) {

    private val maxLoggerNameLength = 40

    fun toText(): String {
        val threadNameFormatted = String.format("%15s", threadName)
        val shortLoggerName = shortenLoggerName(loggerName)
        val loggerNameFormatted = shortLoggerName.padEnd(maxLoggerNameLength)
        return "$timestamp  $level --- [$threadNameFormatted] $loggerNameFormatted: $message"
    }

    private fun shortenLoggerName(loggerName: String): String {
        var result = loggerName

        while (result.length >= maxLoggerNameLength) {
            val blocks = result.split(".").toMutableList()

            for(i in 0 until blocks.size-1) {
                if(blocks[i].length > 1) {
                    blocks[i] = blocks[i].first().toString()
                    break
                }
            }

            result = blocks.joinToString(".")

            if(result.length >= maxLoggerNameLength) {
                result = result.takeLast(maxLoggerNameLength)
            }
        }

        return result
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