package com.android.codequality

import android.app.Application
import android.os.StrictMode
import com.android.codequality.util.doOnDebug

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        setupStrictMode()
    }

    private fun setupStrictMode() {
        doOnDebug {
            StrictMode.setThreadPolicy(
                StrictMode.ThreadPolicy.Builder()
                    .detectDiskReads()
                    .detectDiskWrites()
                    .detectNetwork()
                    .detectCustomSlowCalls()
                    .penaltyLog()
                    .build()
            )

            StrictMode.setVmPolicy(
                StrictMode.VmPolicy.Builder()
                    .detectActivityLeaks()
                    .detectFileUriExposure()
                    .detectLeakedClosableObjects()
                    .detectLeakedRegistrationObjects()
                    .detectLeakedSqlLiteObjects()
                    .penaltyLog()
                    .build()
            )
        }
    }
}
