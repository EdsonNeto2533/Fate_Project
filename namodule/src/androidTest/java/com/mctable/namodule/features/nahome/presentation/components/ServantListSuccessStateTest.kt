package com.mctable.namodule.features.nahome.presentation.components

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import com.mctable.namodule.features.nahome.domain.model.ServantModel
import io.mockk.mockk
import org.junit.Rule
import org.junit.Test

class ServantListSuccessStateTest {

    private val servantListMock = listOf<ServantModel>(
        mockk(relaxed = true),
        mockk(relaxed = true),
        mockk(relaxed = true),
        mockk(relaxed = true),
        mockk(relaxed = true),
        mockk(relaxed = true),
        mockk(relaxed = true),
        mockk(relaxed = true),
    )

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun should_render_the_component_and_find_default_components() {
        var loadMoreWasCalled = false
        composeTestRule.setContent {
            ServantListSuccessState(
                servantsList = servantListMock,
                loadMore = {
                    loadMoreWasCalled = true
                },
            )
        }

        composeTestRule.onNodeWithTag("servant-list-lazy-column-tag").assertExists()

    }


}