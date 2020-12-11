package com.elgendy.olx

import android.app.Application
import com.elgendy.olx.di.ApplicationModule
import com.elgendy.olx.di.NetworkModule
import com.elgendy.olx.di.ViewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication : Application() {

  override fun onCreate() {
    super.onCreate()

    initKoin()
  }

  private fun initKoin() {
    startKoin{
      androidContext(this@MyApplication)
      modules(listOf(ApplicationModule.create(), ViewModelModule.create(), NetworkModule.create()))
    }
  }

}