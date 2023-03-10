package com.example.quickprojectlearning

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class QuickApplication : Application() {

    override fun onCreate() {
        super.onCreate()
    }
}