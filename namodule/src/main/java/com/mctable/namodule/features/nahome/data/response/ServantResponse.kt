package com.mctable.namodule.features.nahome.data.response

import com.google.gson.annotations.SerializedName

data class ServantResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("classId")
    val classId: Int,
    @SerializedName("className")
    val className: String,
    @SerializedName("attribute")
    val attribute: String,
    @SerializedName("rarity")
    val rarity: Int,
    @SerializedName("atkMax")
    val atkMax: Int,
    @SerializedName("hpMax")
    val hpMax: Int,
    @SerializedName("gender")
    val gender: String,
    @SerializedName("cards")
    val cards: List<String>,
    @SerializedName("skills")
    val skills: List<SkillResponse>,
//    @SerializedName("noblePhantasms")
//    val noblePhantasms: List<NoblePhantasmResponse>,
)

data class SkillResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("num")
    val num: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("detail")
    val detail: String,
    @SerializedName("icon")
    val icon: String,
    @SerializedName("coolDown")
    val coolDowns: List<Int>
)

//data class NoblePhantasmResponse()
