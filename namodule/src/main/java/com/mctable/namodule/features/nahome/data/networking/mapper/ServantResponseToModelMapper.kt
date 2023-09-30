package com.mctable.namodule.features.nahome.data.networking.mapper

import com.mctable.core.utils.interfaces.Mapper
import com.mctable.namodule.features.nahome.data.response.ServantResponse
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
                cards = it.cards
            )
        }
    }
}