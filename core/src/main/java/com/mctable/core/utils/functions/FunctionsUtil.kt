package com.mctable.core.utils.functions

import retrofit2.Response

object FunctionsUtil {

    fun <T> getGenericErrorMessage(response: Response<T>): String =
        "Http Exception - status:${response.code()} - body${response.body()}"
}