package com.android.codequality.util

import com.example.namespace.BuildConfig

inline fun doOnDebug(action: () -> Unit) {
    if (BuildConfig.DEBUG) {
        action()
    }
}
