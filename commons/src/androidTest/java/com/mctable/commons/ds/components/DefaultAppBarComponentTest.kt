package com.mctable.commons.ds.components

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import com.mctable.commons.ds.theme.FateProjectTheme
import org.junit.Rule
import org.junit.Test

class DefaultAppBarComponentTest {


    @get:Rule val composeTestRule = createComposeRule()

    @Test
    fun should_render_the_component_and_find_default_components(){

        composeTestRule.setContent {
            FateProjectTheme {
                DefaultAppBarComponent()
            }
        }

        composeTestRule.onNodeWithTag("default-app-bar-tag").assertExists()
        composeTestRule.onNodeWithTag("back-button-tag").assertDoesNotExist()
        composeTestRule.onNodeWithTag("title-tag").assertDoesNotExist()
        composeTestRule.onNodeWithTag("logo-tag").assertExists()
    }

    @Test
    fun should_render_the_component_and_find_the_title_but_not_the_logo(){

        composeTestRule.setContent {
            FateProjectTheme {
                DefaultAppBarComponent(title = "Mock")
            }
        }

        composeTestRule.onNodeWithTag("default-app-bar-tag").assertExists()
        composeTestRule.onNodeWithTag("back-button-tag").assertDoesNotExist()
        composeTestRule.onNodeWithTag("title-tag").assertExists()
        composeTestRule.onNodeWithTag("logo-tag").assertDoesNotExist()
    }

    @Test
    fun should_render_the_component_and_find_back_button(){

        composeTestRule.setContent {
            FateProjectTheme {
                DefaultAppBarComponent(backButtonClick = {})
            }
        }

        composeTestRule.onNodeWithTag("default-app-bar-tag").assertExists()
        composeTestRule.onNodeWithTag("back-button-tag").assertExists()
        composeTestRule.onNodeWithTag("title-tag").assertDoesNotExist()
        composeTestRule.onNodeWithTag("logo-tag").assertExists()
    }


}