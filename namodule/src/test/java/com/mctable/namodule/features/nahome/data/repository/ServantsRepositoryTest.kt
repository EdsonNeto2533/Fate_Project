package com.mctable.namodule.features.nahome.data.repository

import arrow.core.right
import com.mctable.core.utils.classes.BaseResponse
import com.mctable.core.utils.functions.FunctionsUtil
import com.mctable.core.utils.interfaces.Mapper
import com.mctable.namodule.features.nahome.data.networking.datasource.ServantsDataSource
import com.mctable.namodule.features.nahome.data.response.ServantResponse
import com.mctable.namodule.features.nahome.domain.model.ServantModel
import com.mctable.namodule.features.nahome.domain.repository.ServantsRepository
import com.mctable.namodule.features.nahome.mockers.servantListResponse
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
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
class ServantsRepositoryTest {

    private lateinit var repository: ServantsRepository
    private val mapper: Mapper<List<ServantResponse>, List<ServantModel>> = mockk()
    private val dataSource: ServantsDataSource = mockk()
    private val servantResponse: Response<BaseResponse<List<ServantResponse>, Any>> = mockk(relaxed = true)
    private val servantModelList: List<ServantModel> = mockk()
    private val httpException: HttpException = mockk(relaxed = true)

    @Before
    fun setup() {
        repository = ServantsRepositoryImpl(dataSource, mapper)
    }

    @Test
    fun should_return_right_servant_list_when_get_servants_is_called_with_success() = runTest {
        // Arrange
        coEvery { dataSource.getServants(any(), any(), null) } returns servantResponse
        every { servantResponse.code() } returns 200
        every { servantResponse.body()?.data } returns servantListResponse
        every { mapper.transform(servantListResponse) } returns servantModelList

        // Act
        val result = repository.getServants(0, 20, null)

        // Assert
        Assert.assertEquals(result, servantModelList.right())
        coVerify { dataSource.getServants(any(), any(), null) }

    }

    @Test
    fun should_return_left_exception_when_get_servants_is_called_with_success_null_body() =
        runTest {
            // Arrange
            coEvery { dataSource.getServants(any(), any(), null) } returns servantResponse
            every { servantResponse.code() } returns 200
            every { servantResponse.body() } returns null

            // Act
            val result = repository.getServants(0, 20, null)
            val error = result.leftOrNull()
            val exception = Exception(FunctionsUtil.getGenericErrorMessage(servantResponse))

            // Assert
            Assert.assertTrue(
                result.isLeft()
            )
            Assert.assertEquals(error?.message, exception.message)
            coVerify { dataSource.getServants(any(), any(), null) }

        }

    @Test
    fun should_return_left_exception_when_get_servants_is_called_with_errors() =
        runTest {
            // Arrange
            coEvery { dataSource.getServants(any(), any(), null) } throws httpException

            // Act
            val result = repository.getServants(0, 20, null)
            val error = result.leftOrNull()

            // Assert
            Assert.assertTrue(
                result.isLeft()
            )
            Assert.assertEquals(error, httpException)
            coVerify { dataSource.getServants(any(), any(), null) }

        }


    @Test
    fun should_return_right_servant_list_when_get_servants_by_name_is_called_with_success() = runTest {
        // Arrange
        coEvery { dataSource.getServantsByName("mock") } returns servantResponse
        every { servantResponse.code() } returns 200
        every { servantResponse.body()?.data } returns servantListResponse
        every { mapper.transform(servantListResponse) } returns servantModelList

        // Act
        val result = repository.getServantsByName("mock")

        // Assert
        Assert.assertEquals(result, servantModelList.right())
        coVerify { dataSource.getServantsByName("mock") }

    }

    @Test
    fun should_return_left_exception_when_get_servants_by_name_is_called_with_success_null_body() =
        runTest {
            // Arrange
            coEvery { dataSource.getServantsByName("mock") } returns servantResponse
            every { servantResponse.code() } returns 200
            every { servantResponse.body() } returns null

            // Act
            val result = repository.getServantsByName("mock")
            val error = result.leftOrNull()
            val exception = Exception(FunctionsUtil.getGenericErrorMessage(servantResponse))

            // Assert
            Assert.assertTrue(
                result.isLeft()
            )
            Assert.assertEquals(error?.message, exception.message)
            coVerify { dataSource.getServantsByName("mock") }

        }

    @Test
    fun should_return_left_exception_when_get_servants_by_name_is_called_with_errors() =
        runTest {
            // Arrange
            coEvery { dataSource.getServantsByName("mock") } throws httpException

            // Act
            val result = repository.getServantsByName("mock")
            val error = result.leftOrNull()

            // Assert
            Assert.assertTrue(
                result.isLeft()
            )
            Assert.assertEquals(error, httpException)
            coVerify { dataSource.getServantsByName("mock") }

        }
}