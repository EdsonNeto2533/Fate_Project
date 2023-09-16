package com.mctable.core.utils.functions

import io.mockk.mockk
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import retrofit2.Response

@RunWith(JUnit4::class)
class FunctionsUtilTest {

    private val mockResponse: Response<String> = mockk(relaxed = true)

    @Test
    fun should_return_the_default_error_message_when_getGenericErrorMessage_is_called() {
        //Arrange
        val defaultResponse =
            "Http Exception - status:${mockResponse.code()} - body${mockResponse.body()}"

        //Act
        val response = FunctionsUtil.getGenericErrorMessage(mockResponse)

        //Assert
        Assert.assertEquals(defaultResponse, response)


    }
}