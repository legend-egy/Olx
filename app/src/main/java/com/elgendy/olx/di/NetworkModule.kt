package com.elgendy.olx.di

import com.elgendy.olx.data.CarsApi
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val API_URL = "https://storage.googleapis.com/code-challenge/"

object NetworkModule {

  fun create() = module {
    single { provideOkHttpClient() }
    single { provideCarsApi(get()) }
    single { provideRetrofit(get()) }
  }

  private fun provideOkHttpClient() = OkHttpClient()

  private fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder().baseUrl(API_URL).client(okHttpClient)
      .addConverterFactory(GsonConverterFactory.create()).build()
  }

  private fun provideCarsApi(retrofit: Retrofit): CarsApi {
    return retrofit.create(CarsApi::class.java)
  }

}