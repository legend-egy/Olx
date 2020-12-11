package com.elgendy.olx.ui

import com.elgendy.olx.data.BaseRepository
import com.elgendy.olx.data.CarsApi
import com.elgendy.olx.model.Car
import com.elgendy.olx.model.CarsResponse

class MainRepository(private val carsApi: CarsApi) : BaseRepository() {

  suspend fun getCars() = getResult<CarsResponse, List<Car>>(
    dataBuilder = { response -> response.cars.map { Car(it) } },
    call = { carsApi.getCars() }
  )

}