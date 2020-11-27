package com.safeboda.android.core.di.modules

import android.content.Context
import com.google.gson.Gson
import com.safeboda.android.core.utils.Constants
import com.safeboda.android.core.utils.RetrofitClient
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Named

/**
 * Core dependencies will be created and injected from here
 */
@Module
class CoreModule (val context: Context){

    @Provides
    fun provideContext(): Context{

        return context
    }

    @Provides
    fun provideGson(): Gson{

        return Gson()
    }

    @Provides
    @Named("cachingRetrofit")
    fun provideCachingRetrofit(context: Context): Retrofit{

        return RetrofitClient().create(Constants.Network.BASE_URL, context, true)
    }

    @Provides
    @Named("nonCachingRetrofit")
    fun provideNonCachingRetrofit(context: Context): Retrofit{

        return RetrofitClient().create(Constants.Network.BASE_URL, context, false)
    }
}