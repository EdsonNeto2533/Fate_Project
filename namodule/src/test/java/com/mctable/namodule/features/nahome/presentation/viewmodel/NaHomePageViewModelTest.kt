package com.mctable.namodule.features.nahome.presentation.viewmodel

import com.mctable.core.utils.classes.GenericError
import com.mctable.core.utils.classes.UIState
import com.mctable.namodule.features.nahome.domain.model.ServantModel
import com.mctable.namodule.features.nahome.domain.usecase.GetServantsUseCase
import com.mctable.namodule.features.nahome.presentation.viewmodels.NaHomePageViewModel
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
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
    private val coroutineRule = UnconfinedTestDispatcher()

    private val genericLoadingState = UIState.Loading
    private lateinit var genericErrorState: UIState.Failure

    private val servantsList: List<ServantModel> = mockk(relaxed = true)
    private val servantsSuccessState = UIState.Success(servantsList)


    @Before
    fun setup(){
        Dispatchers.setMain(coroutineRule)
        viewModel = NaHomePageViewModel(getServantsUseCase)
    }

    @After
    fun tearDown(){
        Dispatchers.resetMain()
    }


    @Test
    fun should_emit_loading_state_when_get_servants_is_called(){
        // Arrange
        coEvery { getServantsUseCase.execute(any(),any()) } returns flow { emit(genericLoadingState) }

        // Act
        viewModel.getServants()

        // Assert
        Assert.assertEquals(viewModel.servantState.value, genericLoadingState)
    }

    @Test
    fun should_emit_success_state_when_get_servants_is_called(){
        // Arrange
        coEvery { getServantsUseCase.execute(any(),any()) } returns flow { emit(servantsSuccessState) }

        // Act
        viewModel.getServants()

        // Assert
        Assert.assertEquals(viewModel.servantState.value, servantsSuccessState)
    }

    @Test
    fun should_emit_error_state_when_get_servants_is_called(){
        // Arrange
        genericErrorState = UIState.Failure(GenericError("error"))
        coEvery { getServantsUseCase.execute(any(),any()) } returns flow { emit(genericErrorState) }

        // Act
        viewModel.getServants()

        // Assert
        Assert.assertEquals(viewModel.servantState.value, genericErrorState)
    }

}