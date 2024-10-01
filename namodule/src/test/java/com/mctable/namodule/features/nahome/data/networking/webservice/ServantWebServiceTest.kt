package com.mctable.namodule.features.nahome.data.networking.webservice

import com.mctable.core.utils.extensions.enqueueRequest
import com.mctable.namodule.features.nahome.mockers.servantListResponse
import kotlinx.coroutines.test.runTest
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@RunWith(JUnit4::class)
class ServantWebServiceTest {

    private val server = MockWebServer()
    private lateinit var webService: ServantHomeWebService


    @Before
    fun setup() {
        webService = Retrofit.Builder()
            .baseUrl(server.url("/"))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ServantHomeWebService::class.java)
    }

    @After
    fun teardown() {
        server.shutdown()
    }

    @Test
    fun should_return_a_servant_list_response_when_get_servants_is_successful() = runTest {
        server.enqueueRequest("responses/servants_list_200_response.json", 200)

        val result = webService.getServants(0, 1, null)

        Assert.assertEquals(servantListResponse, result.body()?.data)
        Assert.assertEquals(200, result.code())

    }

}