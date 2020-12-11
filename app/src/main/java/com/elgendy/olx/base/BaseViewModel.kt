package com.elgendy.olx.base

import androidx.lifecycle.ViewModel
import com.elgendy.olx.utils.DispatcherProvider
import com.elgendy.olx.utils.RealDispatchers
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancelChildren
import kotlin.coroutines.CoroutineContext

open class BaseViewModel(val dispatchers: DispatcherProvider) : ViewModel(), CoroutineScope {

  override val coroutineContext: CoroutineContext
    get() =  SupervisorJob() + dispatchers.main

  override fun onCleared() {
    super.onCleared()
    coroutineContext.cancelChildren()
  }

}