package com.demo.kmmlibrary

import android.app.Application
import com.datadog.android.Datadog
import com.datadog.android.DatadogSite
import com.datadog.android.core.configuration.Configuration
import com.datadog.android.privacy.TrackingConsent
import com.datadog.android.rum.Rum
import com.datadog.android.rum.RumConfiguration

open class SampleApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initializeDatadog()
    }

    private fun initializeDatadog() {
        val clientToken = "pubd7537ca3f1db4a37c9a7b3c85b998890"
        val environmentName = "staging-1"
        val appVariantName = "<SHELL_APP_1>"

        val configuration = Configuration.Builder(
            clientToken = clientToken,
            env = environmentName,
            variant = appVariantName
        )
            .useSite(DatadogSite.AP1)
            .build()
        Datadog.initialize(applicationContext, configuration, TrackingConsent.GRANTED)

        val applicationId = "bb768919-e28d-4cc4-ac10-6a9d373d17e6"
        val rumConfiguration = RumConfiguration.Builder(applicationId)
            .trackUserInteractions()
            .trackLongTasks(50000).trackFrustrations(true).trackBackgroundEvents(true)
//            .useViewTrackingStrategy(strategy)
            .build()
        Rum.enable(rumConfiguration)
    }
}