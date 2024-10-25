package com.mctable.namodule.features.nahome.presentation.components

import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performScrollToNode
import com.mctable.commons.ds.theme.FateProjectTheme
import org.junit.Rule
import org.junit.Test

class ServantListLoadingStateTest {

    @get:Rule
    val composeTestRule = createComposeRule()


    @Test
    fun should_render_the_component_and_find_default_10_loading_components() {
        composeTestRule.setContent {
            FateProjectTheme {
                ServantListLoadingState()
            }
        }

        (0..9).forEach { index ->
            composeTestRule.onNodeWithTag("servant-lazy-column-loading-tag").performScrollToNode(
                hasTestTag("servant-loading-card-tag-$index")
            )

            composeTestRule.onNodeWithTag("servant-loading-card-tag-$index").assertExists()
        }

        composeTestRule.onNodeWithTag("servant-lazy-column-loading-tag").assertExists()
    }


}