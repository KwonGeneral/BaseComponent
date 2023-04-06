package com.example.basecomponent

import android.util.Log

class KLog {
    companion object {
        fun d(message: String) {
            Log.d("KWON_LOG", message)
        }
    }
}