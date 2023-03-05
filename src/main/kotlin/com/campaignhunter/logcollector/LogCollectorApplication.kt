package com.campaignhunter.logcollector

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class LogCollectorApplication

fun main(args: Array<String>) {
	runApplication<LogCollectorApplication>(*args)
}
