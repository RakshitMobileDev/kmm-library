package com.demo.kmmlibrary

class AndroidAnalyticsManagerDD : DataDogAnalyticsManager {
    override fun logEvent(eventName: String) {
        DataDogLogger.logger.i(eventName)
    }
}

actual fun getAnalyticsManager(): DataDogAnalyticsManager = AndroidAnalyticsManagerDD()