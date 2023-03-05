package com.campaignhunter.logcollector.log

data class LogRequest(
    val appName: String,
    val timestamp: String,
    val message: String,
    val level: String,
    val loggerName: String,
    val threadName: String
)
