package com.mctable.namodule.features.nahome.domain.model

import com.mctable.commons.ds.utils.ServantCard

data class ServantModel(
    val id: Int,
    val name: String,
    val classId: Int,
    val className: String,
    val attribute: String,
    val rarity: Int,
    val atkMax: Int,
    val hpMax: Int,
    val gender: String,
    val cards: List<ServantCard>,
)
