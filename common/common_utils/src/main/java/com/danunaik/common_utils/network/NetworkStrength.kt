package com.danunaik.common_utils.network

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.telephony.PhoneStateListener
import android.telephony.SignalStrength
import android.telephony.TelephonyManager
import android.util.Log

object NetworkStrength {

    private var signalStrengthValue: Int = 0

    fun isNetworkAvailable(context: Context): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val network = connectivityManager.activeNetwork ?: return false
        val activeNetwork = connectivityManager.getNetworkCapabilities(network) ?: return false
        return when {
            activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
            activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
            activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
            else -> false
        }
    }

    fun getSignalStrength(context: Context): Int {
        val telephonyManager = context.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
        telephonyManager.listen(object : PhoneStateListener() {
            override fun onSignalStrengthsChanged(signalStrength: SignalStrength?) {
                super.onSignalStrengthsChanged(signalStrength)
                signalStrength?.let {
                    // Use a more reliable way to determine signal strength, if available
                    signalStrengthValue = when {
                        Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q -> it.getLevel()
                        else -> calculateSignalStrength(it)
                    }
                    Log.d("NetworkUtils", "Cellular signal strength: $signalStrengthValue")
                }
            }
        }, PhoneStateListener.LISTEN_SIGNAL_STRENGTHS)
        return signalStrengthValue
    }

    private fun calculateSignalStrength(signalStrength: SignalStrength): Int {
        return when {
            signalStrength.gsmSignalStrength != SignalStrength.INVALID -> signalStrength.gsmSignalStrength
            else -> 0 // Default value for unknown signal strength
        }
    }
}
