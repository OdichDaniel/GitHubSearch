package com.safeboda.android.search

import android.content.Context
import com.safeboda.android.core.di.DaggerCoreComponent
import com.safeboda.android.core.di.modules.CoreModule
import com.safeboda.android.core.utils.ViewModelFactory
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import java.io.File
import javax.inject.Inject

abstract class Base() {

    lateinit var mockServer: MockWebServer

    @Inject
    lateinit var factory: ViewModelFactory

    @Before
    open fun setUp(){

        setUpMockServer()
        configureDI()

    }

    @After
    open fun tearDown(){

        if(isMockServerEnabled()){

            mockServer.shutdown()
        }
    }



    abstract fun isMockServerEnabled(): Boolean

    private fun setUpMockServer(){

        if(isMockServerEnabled()){

            mockServer = MockWebServer()
            mockServer.start()
        }
    }

    open fun mockHttpResponse(fileName: String, responseCode: Int) = mockServer.enqueue(MockResponse()
        .setResponseCode(responseCode)
        .setBody(getJson(fileName)))

    private fun getJson(path : String) : String {
        val uri = this.javaClass.classLoader!!.getResource(path)
        val file = File(uri.path)
        return String(file.readBytes())
    }

    private fun configureDI(){

        //Inject this class so we can receive dependencies
        //DaggerTes.builder().build().inject(this)
        val coreComponent = DaggerCoreComponent.builder().build()


    }
}