package com.mctable.commons.ds.utils.enums

import androidx.annotation.DrawableRes
import com.mctable.commons.R

enum class ServantClasses(val key: String, @DrawableRes val icon: Int) {
    SABER("saber", R.drawable.class_saber_vect),
    ARCHER("archer", R.drawable.class_archer_vect),
    LANCER("lancer", R.drawable.class_lancer_vect),
    ASSASSIN("assassin", R.drawable.class_assassin_vect),
    CASTER("caster", R.drawable.class_caster_vect),
    RIDER("rider", R.drawable.class_rider_vect),
    ALTER_EGO("alterego", R.drawable.class_alter_ego_png),
    RULER("ruler", R.drawable.class_ruler_png),
    AVENGER("avenger", R.drawable.class_avenger_png),
    PRETENDER("pretender", R.drawable.class_pretender_png),
    FOREIGNER("foreigner", R.drawable.class_foreigner_png),
    BERSERKER("berserker", R.drawable.class_berserker_vect),
    MOON_CANCER("mooncancer", R.drawable.class_moon_cancer_png),
    SHIELDER("shielder", R.drawable.class_shielder_vect)
}