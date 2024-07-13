package com.danunaik.trytestapplication

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.danunaik.common_utils.Activities
import com.danunaik.common_utils.Navigator
import com.danunaik.trytestapplication.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var provider: Navigator.Provider

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Use ViewModelProvider to get the ViewModel
        val mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]

        mainViewModel.isNetworkAvailable.observe(this, Observer { isAvailable ->
            if (isAvailable) {
                mainViewModel.signalStrength.observe(this, Observer { signalStrength ->
                    Handler(Looper.getMainLooper()).postDelayed({
                        provider.getActivities(Activities.NewsActivity).navigate(this)
                    }, 3000)
                })
            } else {
                Toast.makeText(this, "Network Issue Try Again", Toast.LENGTH_LONG).show()
            }
        })

        mainViewModel.checkNetworkStatus()
    }
}
