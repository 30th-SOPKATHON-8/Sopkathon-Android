package org.sopt.sopkathon_8_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("승현", "하이")
        Log.d("승현쌤","최고")
        Log.d("한쌤", "든든하다")
    }
}