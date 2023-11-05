package com.mctable.namodule.features.nahome.data.networking.mapper

import com.mctable.commons.ds.utils.ServantCard
import com.mctable.core.utils.interfaces.Mapper
import com.mctable.namodule.features.nahome.data.response.ServantResponse
import com.mctable.namodule.features.nahome.domain.model.AscensionContentsModel
import com.mctable.namodule.features.nahome.domain.model.CharacterAssetsModel
import com.mctable.namodule.features.nahome.domain.model.ServantModel

class ServantResponseToModelMapper : Mapper<List<ServantResponse>, List<ServantModel>> {
    override fun transform(data: List<ServantResponse>): List<ServantModel> {
        return data.map {
            ServantModel(
                id = it.id,
                name = it.name,
                classId = it.classId,
                className = it.className,
                attribute = it.attribute,
                rarity = it.rarity,
                atkMax = it.atkMax,
                hpMax = it.hpMax,
                gender = it.gender,
                cards = it.cards.map { key ->
                    ServantCard.values().find { card ->
                        card.key == key
                    } ?: ServantCard.ARTS
                },
                characterAssetsModel = CharacterAssetsModel(
                    characterFaces = AscensionContentsModel(
                        first = it.extraAssets.characterFacesResponse.ascensionResponse.first,
                        second = it.extraAssets.characterFacesResponse.ascensionResponse.second,
                        third = it.extraAssets.characterFacesResponse.ascensionResponse.third,
                        fourth = it.extraAssets.characterFacesResponse.ascensionResponse.fourth
                    ),
                    characterImages = AscensionContentsModel(
                        first = it.extraAssets.characterImagesResponse.ascensionResponse.first,
                        second = it.extraAssets.characterImagesResponse.ascensionResponse.second,
                        third = it.extraAssets.characterImagesResponse.ascensionResponse.third,
                        fourth = it.extraAssets.characterImagesResponse.ascensionResponse.fourth
                    )
                )
            )
        }
    }
}