package com.campaignhunter.logcollector.log

import java.io.BufferedWriter
import java.io.File
import java.io.FileWriter

class LogWriter(
    appName: String
) {
    private val logFile: File = File("/log/$appName.log")
    private val sleepTime = 50L

    fun write(log: String) {
        var lockAcquired = false

        while(!lockAcquired) {
            lockAcquired = FileLockManager.acquire(logFile.name)

            if(!lockAcquired) {
                Thread.sleep(sleepTime)
            }
        }

        try {
            val bufferWriter = BufferedWriter(FileWriter(logFile, true))
            bufferWriter.write(log)
            bufferWriter.newLine()
            bufferWriter.flush()
            bufferWriter.close()
        } finally {
            FileLockManager.release(logFile.name)
        }
    }
}