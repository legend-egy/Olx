package com.elgendy.olx.di

import com.elgendy.olx.ui.MainRepository
import com.elgendy.olx.utils.DispatcherProvider
import com.elgendy.olx.utils.RealDispatchers
import org.koin.dsl.module

object ApplicationModule {

  fun create() = module {

    single<DispatcherProvider> { RealDispatchers }
    factory { MainRepository(get()) }

  }



}