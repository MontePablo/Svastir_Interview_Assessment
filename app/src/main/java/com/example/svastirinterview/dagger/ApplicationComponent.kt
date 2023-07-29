package com.example.svastirinterview.dagger

import com.example.svastirinterview.MainActivity
import com.example.svastirinterview.retrofit.RetrofitDaggerModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [RetrofitDaggerModule::class])
interface ApplicationComponent {
    fun inject(mainActivity: MainActivity)
}