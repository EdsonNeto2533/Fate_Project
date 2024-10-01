package com.mctable.namodule.features.nahome.domain.usecase

import arrow.core.left
import arrow.core.right
import com.mctable.core.utils.classes.GenericError
import com.mctable.core.utils.classes.UIState
import com.mctable.namodule.features.nahome.domain.model.ServantModel
import com.mctable.namodule.features.nahome.domain.repository.ServantsRepository
import com.mctable.namodule.features.nahome.domain.usecase.impl.GetServantsByNameUseCaseImpl
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class GetServantsByNamesUseCaseTest {

    private lateinit var useCase: GetServantsByNameUseCase
    private val servantListMock: List<ServantModel> = mockk()
    private val repository: ServantsRepository = mockk()
    private val genericException: Exception = mockk(relaxed = true)

    @Before
    fun setup() {
        useCase = GetServantsByNameUseCaseImpl(repository)
    }

    @Test
    fun should_emit_loading_and_success_when_get_servants_use_case_is_called() = runTest {
        // Arrange
        coEvery { repository.getServantsByName("mock") } returns servantListMock.right()

        // Act
        val result = useCase.execute("mock").toList()

        // Assert
        Assert.assertEquals(
            result, listOf(
                UIState.Loading,
                UIState.Success(servantListMock)
            )
        )
        coVerify { repository.getServantsByName("mock") }
    }

    @Test
    fun should_emit_loading_and_error_when_get_servants_use_case_is_called_with_errors() = runTest {
        // Arrange
        coEvery { repository.getServantsByName("mock") } returns genericException.left()

        // Act
        val result = useCase.execute("mock").toList()

        // Assert
        Assert.assertEquals(
            result, listOf(
                UIState.Loading,
                UIState.Failure(GenericError(genericException.message))
            )
        )
        coVerify { repository.getServantsByName("mock") }
    }
}