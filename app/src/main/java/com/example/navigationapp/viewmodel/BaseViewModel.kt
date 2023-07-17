package com.example.navigationapp.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.navigationapp.navigation.command.NavigationCommand
import com.example.navigationapp.util.coroutines.DefaultCoroutineContextProvider
import com.example.navigationapp.util.extensions.TAG
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

open class BaseViewModel : ViewModel() {

    protected val ioContext: CoroutineContext = DefaultCoroutineContextProvider.io
    protected val mainContext: CoroutineContext = DefaultCoroutineContextProvider.main

    protected val _navigationCommand: MutableSharedFlow<NavigationCommand?> =
        MutableSharedFlow(extraBufferCapacity = 1)
    val navigationCommand = _navigationCommand.asSharedFlow()

    init {
        viewModelScope.coroutineContext + CoroutineExceptionHandler(
            handler = { context, exception ->
                Log.e(
                    this@BaseViewModel.TAG,
                    "CoroutineExceptionHandler handled exception in ${this@BaseViewModel}. Exception: ${exception.stackTraceToString()}"
                )
            }
        )
    }

    fun launch(
        context: CoroutineContext = EmptyCoroutineContext,
        block: suspend CoroutineScope.() -> Unit
    ) = viewModelScope.launch(context, block = block)
}
