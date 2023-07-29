package com.example.svastirinterview.dagger

import android.app.Application

class ApplicationComponentProvider: Application() {
    lateinit var applicationComponent: ApplicationComponent
    override fun onCreate() {
        super.onCreate()
        applicationComponent=DaggerApplicationComponent.builder().build()
    }
}