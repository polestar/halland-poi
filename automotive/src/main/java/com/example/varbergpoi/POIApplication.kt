package com.example.varbergpoi

import android.app.Application
import com.example.varbergpoi.dummydata.DummyHandler

class POIApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        ObjectBox.init(this)
        DummyHandler.initDummyData()
    }
}