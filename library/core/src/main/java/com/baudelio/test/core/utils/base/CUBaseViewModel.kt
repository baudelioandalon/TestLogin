package com.baudelio.test.core.utils.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.baudelio.test.core.utils.extensions.log
import kotlinx.coroutines.launch

abstract class CUBaseViewModel : ViewModel() {

    protected fun executeFlow(block: suspend () -> Unit) = viewModelScope.launch {
        try {
            block.invoke()
        } catch (e: Exception) {
            e.stackTraceToString().log("ERROR_VMODEL")
        }
    }
}