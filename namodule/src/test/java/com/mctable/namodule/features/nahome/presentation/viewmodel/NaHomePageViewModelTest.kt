package com.mctable.namodule.features.nahome.presentation.viewmodel

import androidx.compose.runtime.collectAsState
import com.mctable.core.utils.classes.GenericError
import com.mctable.core.utils.classes.UIState
import com.mctable.namodule.features.nahome.domain.model.ServantModel
import com.mctable.namodule.features.nahome.domain.usecase.GetServantsByNameUseCase
import com.mctable.namodule.features.nahome.domain.usecase.GetServantsUseCase
import com.mctable.namodule.features.nahome.presentation.viewmodels.NaHomePageViewModel
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.advanceTimeBy
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@OptIn(ExperimentalCoroutinesApi::class)
@RunWith(JUnit4::class)
class NaHomePageViewModelTest {

    private lateinit var viewModel: NaHomePageViewModel
    private val getServantsUseCase: GetServantsUseCase = mockk()
    private val getServantsByNameUseCase: GetServantsByNameUseCase = mockk()
    private val coroutineRule = UnconfinedTestDispatcher()

    private val genericLoadingState = UIState.Loading
    private lateinit var genericErrorState: UIState.Failure

    private val servantsList: List<ServantModel> = mockk(relaxed = true)
    private val servantsSuccessState = UIState.Success(servantsList)


    @Before
    fun setup() {
        Dispatchers.setMain(coroutineRule)
        viewModel = NaHomePageViewModel(getServantsUseCase, getServantsByNameUseCase)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }


    @Test
    fun should_emit_loading_state_when_get_servants_is_called() {
        // Arrange
        coEvery { getServantsUseCase.execute(any(), any(), null) } returns flow {
            emit(
                genericLoadingState
            )
        }

        // Act
        viewModel.getServants()

        // Assert
        Assert.assertEquals(viewModel.servantState.value, genericLoadingState)
    }

    @Test
    fun should_emit_success_state_when_get_servants_is_called() {
        // Arrange
        coEvery { getServantsUseCase.execute(any(), any(), null) } returns flow {
            emit(
                servantsSuccessState
            )
        }

        // Act
        viewModel.getServants()

        // Assert
        Assert.assertEquals(viewModel.servantState.value, servantsSuccessState)
    }

    @Test
    fun should_emit_error_state_when_get_servants_is_called() {
        // Arrange
        genericErrorState = UIState.Failure(GenericError("error"))
        coEvery { getServantsUseCase.execute(any(), any(), null) } returns flow {
            emit(
                genericErrorState
            )
        }

        // Act
        viewModel.getServants()

        // Assert
        Assert.assertEquals(viewModel.servantState.value, genericErrorState)
    }

    @Test
    fun should_emit_loading_false_load_more_enable_and_servant_list_when_load_more_servants_is_called() {
        val index = 20
        coEvery { getServantsUseCase.execute(index + 1, any(), null) } returns flow {
            emit(
                servantsSuccessState
            )
        }

        viewModel.loadMoreServants(index)

        // Assert
        Assert.assertEquals(viewModel.showLoadingDialogState.value, false)
        Assert.assertEquals(viewModel.enableLoadMore.value, true)
        Assert.assertEquals(viewModel.servantState.value, servantsSuccessState)
    }

    @Test
    fun should_emit_loading_true_and_false_when_load_more_servants_is_called_with_success() =
        runTest {
            val index = 20
            coEvery { getServantsUseCase.execute(index + 1, any(), null) } returns flow {
                delay(50)
                emit(
                    servantsSuccessState
                )
            }

            val results = mutableListOf<Boolean>()
            val job = launch {
                viewModel.showLoadingDialogState.collect {
                    results.add(it)
                }
            }

            viewModel.loadMoreServants(index)

            advanceTimeBy(100)
            job.cancel()

            Assert.assertEquals(results, listOf(true, false))
        }

    @Test
    fun should_emit_loading_true_when_load_more_servants_is_called_with_loading_state() = runTest {
        val index = 20
        coEvery { getServantsUseCase.execute(index + 1, any(), null) } returns flow {
            delay(50)
            emit(
                genericLoadingState
            )
        }

        val results = mutableListOf<Boolean>()
        val job = launch {
            viewModel.showLoadingDialogState.collect {
                results.add(it)
            }
        }

        viewModel.loadMoreServants(index)

        advanceTimeBy(100)
        job.cancel()

        Assert.assertEquals(results, listOf(true))
    }

    @Test
    fun should_emit_servant_state_success_when_get_servants_by_name_is_called_with_success() =
        runTest {
            coEvery { getServantsByNameUseCase.execute("mock") } returns flow {
                emit(
                    servantsSuccessState
                )
            }

            viewModel.loadServantsByName("mock")

            Assert.assertEquals(viewModel.enableLoadMore.value, false)
            Assert.assertEquals(viewModel.servantState.value, servantsSuccessState)
        }

    @Test
    fun should_emit_success_state_when_reset_list_is_called() {
        // Arrange
        coEvery { getServantsUseCase.execute(any(), any(), null) } returns flow {
            emit(
                servantsSuccessState
            )
        }

        // Act
        viewModel.resetList()

        // Assert
        Assert.assertEquals(viewModel.servantState.value, servantsSuccessState)
    }

    @Test
    fun should_call_get_servants_with_class_filter_value_when_filter_servants_by_class_is_called() {
        // Arrange
        coEvery { getServantsUseCase.execute(any(), any(), "mock") } returns flow {
            emit(
                servantsSuccessState
            )
        }

        // Act
        viewModel.filterServantsByClass("mock")

        // Assert
        Assert.assertEquals(viewModel.servantState.value, servantsSuccessState)
    }

}