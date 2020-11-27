package com.safeboda.android.di.modules

import com.safeboda.android.api.NetworkApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    fun networkApi(@Named("cachingRetrofit") retrofit: Retrofit): NetworkApi{

        return  retrofit.create(NetworkApi::class.java)
    }
}