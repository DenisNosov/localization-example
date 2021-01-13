package com.example.android.localizationexample

import android.app.Application
import com.example.android.localizationexample.manager.LocalizationManager

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        LocalizationManager.init(applicationContext)
    }

}