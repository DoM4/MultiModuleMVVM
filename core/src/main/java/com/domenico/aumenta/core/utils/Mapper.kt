package com.domenico.aumenta.core.utils

interface Mapper<I, O> {
    fun map(input: I): O
}