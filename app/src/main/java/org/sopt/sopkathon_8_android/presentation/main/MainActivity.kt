package org.sopt.sopkathon_8_android.presentation.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.sopt.sopkathon_8_android.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}