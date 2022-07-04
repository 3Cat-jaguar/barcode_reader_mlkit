package com.example.barcode_scanner

import android.app.Application
import timber.log.Timber

class BarcodeScanner : Application() {

    init {
        val application = this
    }

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}