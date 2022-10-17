package com.android.codequality.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.namespace.R
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        GlobalScope.launch {
            delay(2000)
        }
    }
}
