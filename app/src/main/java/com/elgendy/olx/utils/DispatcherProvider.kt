package com.elgendy.olx.utils

import kotlinx.coroutines.CoroutineDispatcher

interface DispatcherProvider  {
  val main: CoroutineDispatcher
  val io: CoroutineDispatcher
}