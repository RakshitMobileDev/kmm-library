package com.demo.kmmlibrary

import com.datadog.android.log.Logger

object DataDogLogger {
    val logger = Logger.Builder()
        .setNetworkInfoEnabled(true)
        .setLogcatLogsEnabled(true)
        .setRemoteSampleRate(100f)
        .setBundleWithTraceEnabled(true)
        .setBundleWithRumEnabled(true)
        .setName("Shell_App_Logger")
        .build()
}