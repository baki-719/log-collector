package com.campaignhunter.logcollector.log

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("log")
class LogController(
    private val logService: LogService
) {

    @PostMapping
    suspend fun log(@RequestBody request: LogRequest): ResponseEntity<Void> {
        println(request.toString())
        logService.log(Log.from(request))
        return ResponseEntity.ok().build()
    }
}