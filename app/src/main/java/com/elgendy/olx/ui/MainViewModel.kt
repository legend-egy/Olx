package com.elgendy.olx.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.elgendy.olx.base.BaseViewModel
import com.elgendy.olx.data.BaseResult
import com.elgendy.olx.data.BaseResult.Status.ERROR
import com.elgendy.olx.data.BaseResult.Status.SUCCESS
import com.elgendy.olx.model.Car
import com.elgendy.olx.utils.DispatcherProvider
import com.elgendy.olx.utils.RealDispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(
  private val repository: MainRepository,
  dispatchers: DispatcherProvider = RealDispatchers
) : BaseViewModel(dispatchers) {

  private val _viewState = MutableLiveData<BaseResult<List<Car>>>()
  val viewState: LiveData<BaseResult<List<Car>>>
    get() = _viewState

  init {
    fetchCars()
  }

  fun fetchCars() = launch {
    _viewState.value = BaseResult.loading()
    val result: BaseResult<List<Car>> = withContext(dispatchers.io) {
      repository.getCars()
    }
    _viewState.value = result
  }

}