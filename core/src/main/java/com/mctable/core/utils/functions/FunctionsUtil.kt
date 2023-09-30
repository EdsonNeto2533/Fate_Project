package com.mctable.core.utils.functions

import retrofit2.Response

object FunctionsUtil {

    fun <T> getGenericErrorMessage(response: Response<T>): String =
        "Error - status:${response.code()} - body${response.body()}"
}