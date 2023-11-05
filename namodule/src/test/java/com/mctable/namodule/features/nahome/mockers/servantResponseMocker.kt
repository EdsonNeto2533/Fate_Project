package com.mctable.namodule.features.nahome.mockers

import com.mctable.namodule.features.nahome.data.response.AscensionResponse
import com.mctable.namodule.features.nahome.data.response.AssetsInfoResponse
import com.mctable.namodule.features.nahome.data.response.CharacterAssetsResponse
import com.mctable.namodule.features.nahome.data.response.ServantResponse
import com.mctable.namodule.features.nahome.data.response.SkillResponse

val servantListResponse: List<ServantResponse> = listOf(
    ServantResponse(
        id = 100100,
        name = "Altria Pendragon",
        classId = 1,
        className = "saber",
        attribute = "earth",
        rarity = 5,
        atkMax = 11221,
        hpMax = 15150,
        gender = "female",
        cards = listOf(
            "quick",
            "arts",
            "arts",
            "buster",
            "buster"
        ),
        skills = listOf(
            SkillResponse(
                id = 5450,
                num = 1,
                name = "Charisma B",
                detail = "Increase all allies' ATK (3 turns)",
                icon = "https://static.atlasacademy.io/NA/SkillIcons/skill_00300.png",
                coolDowns = listOf(
                    7,
                    7,
                    7,
                    7,
                    7,
                    6,
                    6,
                    6,
                    6,
                    5
                )
            )
        ),
        extraAssets = CharacterAssetsResponse(
            characterImagesResponse = AssetsInfoResponse(
                ascensionResponse = AscensionResponse(
                    first = "https://static.atlasacademy.io/NA/CharaGraph/100100/100100a@1.png",
                    second = "https://static.atlasacademy.io/NA/CharaGraph/100100/100100a@2.png",
                    third = "https://static.atlasacademy.io/NA/CharaGraph/100100/100100b@1.png",
                    fourth = "https://static.atlasacademy.io/NA/CharaGraph/100100/100100b@2.png"
                )
            ), characterFacesResponse = AssetsInfoResponse(
                ascensionResponse = AscensionResponse(
                    first = "https://static.atlasacademy.io/NA/Faces/f_1001000.png",
                    second = "https://static.atlasacademy.io/NA/Faces/f_1001001.png",
                    third = "https://static.atlasacademy.io/NA/Faces/f_1001002.png",
                    fourth = "https://static.atlasacademy.io/NA/Faces/f_1001003.png"
                )
            )
        )
    )
)