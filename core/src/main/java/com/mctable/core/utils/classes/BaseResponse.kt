package com.mctable.core.utils.classes

import com.google.gson.annotations.SerializedName

data class BaseResponse<T, R>(
    @SerializedName("success")
    val isSuccess: Boolean,
    @SerializedName("data")
    val data: T?,
    @SerializedName("message")
    val message: String?,
    @SerializedName("error")
    val error: R?,
)
