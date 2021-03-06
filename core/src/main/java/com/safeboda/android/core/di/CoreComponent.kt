package com.safeboda.android.core.di

import android.content.Context
import com.google.gson.Gson
import com.safeboda.android.core.di.modules.CoreModule
import dagger.Component
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Singleton

@Singleton
@Component(modules = [CoreModule::class])
interface CoreComponent {

    fun provideContext(): Context

    fun provideGson(): Gson

    @Named("cachingRetrofit")
    fun provideCachingRetrofit(): Retrofit

    @Named("nonCachingRetrofit")
    fun provideNonCachingRetrofit(): Retrofit
}