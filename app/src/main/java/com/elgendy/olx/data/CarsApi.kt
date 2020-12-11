package com.elgendy.olx.data

import com.elgendy.olx.model.CarsResponse
import retrofit2.http.GET

interface CarsApi {

  @GET("cars.json")
  suspend fun getCars() : CarsResponse

}