package com.demo.kmmlibrary

interface DataDogAnalyticsManager {
    fun logEvent(eventName: String)
}

expect fun getAnalyticsManager(): DataDogAnalyticsManager

