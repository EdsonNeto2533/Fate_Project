package com.mctable.core.network

import okhttp3.logging.HttpLoggingInterceptor

object Interceptors {

    val loggingInterceptor = HttpLoggingInterceptor()
        .setLevel(HttpLoggingInterceptor.Level.BODY)
}