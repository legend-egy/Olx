package com.elgendy.olx.di

import com.elgendy.olx.ui.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object ViewModelModule {

  fun create() = module {

    viewModel { MainViewModel(get()) }

  }

}