package com.elgendy.olx.model

import com.google.gson.annotations.SerializedName

data class CarsResponse(
  val results: Int,
  @SerializedName("data") val cars: List<CarResponse>
)

data class CarResponse(
  @SerializedName("image_url") val image: String,
  val make: MakeResponse,
  val name: String
)

data class MakeResponse(val key: String, val label: String)