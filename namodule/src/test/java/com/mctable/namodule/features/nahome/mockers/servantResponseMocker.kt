package com.mctable.namodule.features.nahome.mockers

import com.mctable.namodule.features.nahome.data.response.ServantResponse
import com.mctable.namodule.features.nahome.data.response.SkillResponse

val servantResponse: List<ServantResponse> = listOf(
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
    )
)