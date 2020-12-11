package com.elgendy.olx.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.elgendy.olx.R
import com.elgendy.olx.data.BaseResult.Status.SUCCESS
import com.elgendy.olx.data.BaseResult.Status.ERROR
import com.elgendy.olx.data.BaseResult.Status.LOADING
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

  private val viewModel: MainViewModel by viewModel()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)


    viewModel.viewState.observe(this, { result ->

      when (result.status) {
        SUCCESS -> {
          println("SUCCESS : ${result.data}")
        }
        LOADING -> {
          println("LOADING")
        }
        ERROR -> {
          println("ERROR")
        }
      }

    })
  }
}