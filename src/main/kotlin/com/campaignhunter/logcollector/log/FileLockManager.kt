package com.campaignhunter.logcollector.log

import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.Semaphore

object FileLockManager {

    private val lockMap: MutableMap<String, Semaphore> = ConcurrentHashMap()

    fun acquire(fileName: String): Boolean {
        val lockState = lockMap.computeIfAbsent(fileName) { Semaphore(1) }

        return try {
            lockState.acquire()
            true
        } catch (e: InterruptedException) {
            false
        }
    }

    fun release(fileName: String) {
        lockMap[fileName]?.release()
    }
}