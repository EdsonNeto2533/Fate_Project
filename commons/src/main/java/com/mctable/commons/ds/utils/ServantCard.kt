package com.mctable.commons.ds.utils

import androidx.annotation.DrawableRes
import com.mctable.commons.R

enum class ServantCard(val key: String, @DrawableRes drawable: Int) {
    QUICK("quick", R.drawable.quick_card),
    ARTS("arts", R.drawable.arts_card),
    BUSTER("buster",R.drawable.buster_card),
}