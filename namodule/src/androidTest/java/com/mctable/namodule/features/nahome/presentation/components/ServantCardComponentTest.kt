package com.mctable.namodule.features.nahome.presentation.components

import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import com.mctable.commons.ds.theme.FateProjectTheme
import com.mctable.commons.ds.utils.ServantCard
import com.mctable.namodule.features.nahome.domain.model.AscensionContentsModel
import com.mctable.namodule.features.nahome.domain.model.CharacterAssetsModel
import com.mctable.namodule.features.nahome.domain.model.ServantModel
import org.junit.Rule
import org.junit.Test

class ServantCardComponentTest {


    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun should_render_the_component_and_find_default_components() {

        composeTestRule.setContent {
            FateProjectTheme {
                ServantCardComponent(
                    servantModel = ServantModel(
                        id = 8052,
                        name = "Juanita Garcia",
                        classId = 7589,
                        className = "Alberto Chapman",
                        attribute = "prodesset",
                        rarity = 8817,
                        atkMax = 9691,
                        hpMax = 3101,
                        gender = "maluisset",
                        cards = listOf(
                            ServantCard.ARTS,
                            ServantCard.ARTS,
                            ServantCard.ARTS,
                            ServantCard.QUICK,
                            ServantCard.BUSTER
                        ),
                        characterAssetsModel = CharacterAssetsModel(
                            characterImages = AscensionContentsModel(
                                first = "dicunt",
                                second = "utinam",
                                third = "litora",
                                fourth = "detracto"
                            ), characterFaces = AscensionContentsModel(
                                first = "magnis",
                                second = "error",
                                third = "altera",
                                fourth = "venenatis"
                            )
                        )
                    )
                )
            }
        }

        composeTestRule.onNodeWithTag("servant-card-tag").assertExists()
        composeTestRule.onNodeWithTag("servant-list-item-tag").assertExists()
        composeTestRule.onNodeWithTag("servant-name-tag", useUnmergedTree = true).assertExists()
        composeTestRule.onNodeWithTag("servant-image-tag", useUnmergedTree = true).assertExists()
        composeTestRule.onNodeWithTag("servant-class-image-tag", useUnmergedTree = true).assertExists()
        composeTestRule.onNodeWithTag("servant-class-name-tag", useUnmergedTree = true).assertExists()
        composeTestRule.onAllNodes(hasTestTag("servant-card-image-tag-arts"), useUnmergedTree = true).assertCountEquals(3)
        composeTestRule.onAllNodes(hasTestTag("servant-card-image-tag-quick"), useUnmergedTree = true).assertCountEquals(1)
        composeTestRule.onAllNodes(hasTestTag("servant-card-image-tag-buster"), useUnmergedTree = true).assertCountEquals(1)
    }
}