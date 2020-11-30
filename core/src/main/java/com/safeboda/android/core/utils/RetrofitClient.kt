package com.safeboda.android.core.utils

import android.content.Context
import android.util.Log
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File

/**
 *  This is a factory util class to create both caching and non-caching retrofit
 *
 */
class RetrofitClient {

    private lateinit var context: Context
    private var cacheResponse: Boolean = false

    private val LOG_TAG = "log_tag"

    /**
     * @param baseUrl, base url required by retrofit
     * @param cacheResponse, whether retrofit should cache responses for offline
     * @return, returns retrofit
     */
    fun create(baseUrl: String, context: Context, cacheResponse: Boolean = false): Retrofit{

        this.cacheResponse = cacheResponse
        this.context = context

        val retrofit = Retrofit.Builder().baseUrl(baseUrl)

            // Use okhttp client
            .client(getOkHttpClient())
            .addConverterFactory(GsonConverterFactory.create())

        return retrofit.build()
    }

    private fun getOkHttpClient(): OkHttpClient{

        val okHttpClientBuilder = OkHttpClient.Builder()

        // If we must cache
        if (cacheResponse) {

            val httpCacheDirectory = File(context.getCacheDir(), "http-cache")
            val cacheSize: Long = 10 * 1024 * 1024 // 10 MiB
            val cache = Cache(httpCacheDirectory, cacheSize)

            okHttpClientBuilder.cache(cache)

            okHttpClientBuilder.addInterceptor(object: Interceptor{
                override fun intercept(chain: Interceptor.Chain): Response {

                    val request = chain.request().newBuilder()
                        .header("Cache-Control",
                            "public, only-if-cached, max-stale=" + 2419200)
                        .build();

                    val response = chain.proceed(request)

                    // Add offline caching headers

                    return response.newBuilder()
                        .removeHeader("Pragma")
                        .removeHeader("Cache-Control")

                            // Cache for seven days
                        .addHeader("Cache-Control", "public, max-age=" + 60 * 60 * 24 * 7)
                        .build()
                }

            })
        }

        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        okHttpClientBuilder.addInterceptor(httpLoggingInterceptor)

        return okHttpClientBuilder.build()
    }


    private val httpLoggingInterceptor = HttpLoggingInterceptor(object: HttpLoggingInterceptor.Logger{

        override fun log(message: String) {

            Log.d(LOG_TAG, message)
        }
    })
}