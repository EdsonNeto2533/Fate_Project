package com.mctable.namodule.features.nahome.data.networking.datasource

import com.mctable.namodule.features.nahome.data.networking.datasource.impl.ServantsDataSourceImpl
import com.mctable.namodule.features.nahome.data.networking.webservice.ServantHomeWebService
import com.mctable.namodule.features.nahome.data.response.ServantResponse
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import retrofit2.HttpException
import retrofit2.Response

@RunWith(JUnit4::class)
class ServantDataSourceTests {

    private lateinit var dataSource: ServantsDataSource

    private val webService: ServantHomeWebService = mockk()
    private val servantListMock: Response<List<ServantResponse>> = mockk()
    private val httpException: HttpException = mockk()

    @Before
    fun setup() {
        dataSource = ServantsDataSourceImpl(webService)
    }

    @Test
    fun should_return_a_servant_list_when_getServants_is_called_with_success() = runTest {
        // Arrange
        coEvery { webService.getServants(any(), any()) } returns servantListMock

        // Act
        val response = dataSource.getServants(0, 20)

        // Assert
        Assert.assertEquals(servantListMock, response)
        coVerify { webService.getServants(any(), any()) }
    }

    @Test
    fun should_throw_an_httpException_when_the_is_a_network_error() {
        // Arrange
        coEvery { webService.getServants(any(), any()) } throws httpException

        // Assert
        Assert.assertThrows(HttpException::class.java) {
            runTest {
                dataSource.getServants(0, 20)
            }
        }
        coVerify { webService.getServants(any(), any()) }

    }
}