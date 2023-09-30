package com.mctable.namodule.features.nahome.domain.usecase

import arrow.core.left
import arrow.core.right
import com.mctable.core.utils.classes.GenericError
import com.mctable.core.utils.classes.UIState
import com.mctable.namodule.features.nahome.domain.model.ServantModel
import com.mctable.namodule.features.nahome.domain.repository.ServantsRepository
import com.mctable.namodule.features.nahome.domain.usecase.impl.GetServantsUseCaseImpl
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class GetServantsUseCaseTest {

    private lateinit var useCase: GetServantsUseCase
    private val servantListMock: List<ServantModel> = mockk()
    private val repository: ServantsRepository = mockk()
    private val genericException: Exception = mockk(relaxed = true)

    @Before
    fun setup() {
        useCase = GetServantsUseCaseImpl(repository)
    }

    @Test
    fun should_emit_loading_and_success_when_get_servants_use_case_is_called() = runTest {
        // Arrange
        coEvery { repository.getServants(any(), any()) } returns servantListMock.right()

        // Act
        val result = useCase.execute(0, 20).toList()

        // Assert
        Assert.assertEquals(
            result, listOf(
                UIState.Loading,
                UIState.Success(servantListMock)
            )
        )
        coVerify { repository.getServants(any(), any()) }
    }

    @Test
    fun should_emit_loading_and_error_when_get_servants_use_case_is_called_with_errors() = runTest {
        // Arrange
        coEvery { repository.getServants(any(), any()) } returns genericException.left()

        // Act
        val result = useCase.execute(0, 20).toList()

        // Assert
        Assert.assertEquals(
            result, listOf(
                UIState.Loading,
                UIState.Failure(GenericError(genericException.message))
            )
        )
        coVerify { repository.getServants(any(), any()) }
    }
}