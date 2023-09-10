package com.mctable.core.utils.interfaces

interface Mapper<I, O> {
    fun transform(data: I): O
}