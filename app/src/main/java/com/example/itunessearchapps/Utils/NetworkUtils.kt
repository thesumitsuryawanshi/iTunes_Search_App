package com.example.itunessearchapps.Utils

import android.content.Context
import android.net.ConnectivityManager
import android.util.Log.d

class NetworkUtils {

    companion object {
        fun isNetworkAvailable(context: Context): Boolean {

            val connectivityManager =
                context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

            if (connectivityManager.activeNetworkInfo != null && connectivityManager.activeNetworkInfo!!.isConnectedOrConnecting) {
                d("testing", "internet is avtiive ")
                return true
            }
            return false
        }
    }

}


