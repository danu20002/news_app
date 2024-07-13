package com.danunaik.trytestapplication.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.danunaik.common_utils.network.NetworkStrength


class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val _isNetworkAvailable = MutableLiveData<Boolean>()
    val isNetworkAvailable: LiveData<Boolean> get() = _isNetworkAvailable

    private val _signalStrength = MutableLiveData<Int>()
    val signalStrength: LiveData<Int> get() = _signalStrength

    fun checkNetworkStatus() {
        _isNetworkAvailable.value = NetworkStrength.isNetworkAvailable(getApplication())
        _signalStrength.value = NetworkStrength.getSignalStrength(getApplication())
    }
}
