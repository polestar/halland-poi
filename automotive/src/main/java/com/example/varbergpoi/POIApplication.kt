package com.example.varbergpoi

import android.app.Application
import com.example.varbergpoi.dummydata.DummyHandler
import timber.log.Timber

class POIApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        ObjectBox.init(this)
        DummyHandler.initDummyData()

        Timber.plant(Timber.DebugTree())
    }
}