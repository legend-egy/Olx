package com.elgendy.olx.data


open class BaseRepository {

  protected suspend fun <R, T> getResult(
    dataBuilder: (R) -> T,
    call: suspend () -> Any
  ): BaseResult<T> =
    try {
      val response = call()
      val data = dataBuilder(response as R)
      BaseResult.success(data)
    } catch (throwable: Throwable) {
      BaseResult.error(throwable.message)
    }
  
}