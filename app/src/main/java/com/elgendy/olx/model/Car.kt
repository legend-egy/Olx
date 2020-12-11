package com.elgendy.olx.model

data class Car(
  val image: String,
  val name: String,
  val label: String
) {

  constructor(carsResponse: CarResponse) : this (
    image = carsResponse.image,
    name = carsResponse.name,
    label = carsResponse.make.label
  )

}