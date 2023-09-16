package com.mctable.core.utils.extensions

import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okio.buffer
import okio.source

fun MockWebServer.enqueueRequest(jsonPath: String, statusCode: Int) {
    javaClass.classLoader?.let {
        val inputStream = it.getResourceAsStream(jsonPath)
        val source = inputStream.source().buffer()

        val mockResponse = MockResponse().apply {
            setResponseCode(statusCode)
            setBody(source.readString(java.nio.charset.StandardCharsets.UTF_8))
        }

        enqueue(mockResponse)
    }
}