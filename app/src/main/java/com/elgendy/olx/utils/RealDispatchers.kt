package com.elgendy.olx.utils

import kotlinx.coroutines.Dispatchers

object RealDispatchers : DispatcherProvider {
  override val main  = Dispatchers.Main
  override val io = Dispatchers.IO
}