package com.example.svastirinterview.retrofit

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
object  RetrofitDaggerModule {
    val apiUrl="https://jsonplaceholder.typicode.com/"

    @Singleton
    @Provides
    fun provideRetrofit():Retrofit {
        return Retrofit.Builder().baseUrl(apiUrl)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }
    @Singleton
    @Provides
    fun provideRetrofitApiHolder(retrofit:Retrofit):RetrofitApiHolder{
        return retrofit.create(RetrofitApiHolder::class.java)
    }

}