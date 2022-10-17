package com.android.codequality.ui

import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.namespace.R

class MainActivity : AppCompatActivity() {

    init {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Handler().postDelayed({
            Log.d("TAG", "Delayed message")
        }, 2000)


        try {

        } catch (e: Exception) {
            throw e
        }
    }
}
