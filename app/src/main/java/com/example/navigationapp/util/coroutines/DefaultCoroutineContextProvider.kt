package com.example.navigationapp.util.coroutines

import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

interface CoroutineContextProvider {
    val io: CoroutineContext
    val main: CoroutineContext
}

object DefaultCoroutineContextProvider : CoroutineContextProvider {
    override val io: CoroutineContext
        get() = Dispatchers.IO
    override val main: CoroutineContext
        get() = Dispatchers.Main
}
