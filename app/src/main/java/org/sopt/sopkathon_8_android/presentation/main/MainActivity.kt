package org.sopt.sopkathon_8_android.presentation.main

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import org.sopt.sopkathon_8_android.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        clickAll()
        clickGood()
        clickBad()
    }

    private fun clickAll() {
        binding.tvTotal.setOnClickListener {
            binding.vTabLine1.visibility = View.VISIBLE
            binding.vTabLine2.visibility = View.INVISIBLE
            binding.vTabLine3.visibility = View.INVISIBLE
        }
    }

    private fun clickGood() {
        binding.tvGood.setOnClickListener {
            binding.vTabLine2.visibility = View.VISIBLE
            binding.vTabLine1.visibility = View.INVISIBLE
            binding.vTabLine3.visibility = View.INVISIBLE
        }
    }

    private fun clickBad() {
        binding.tvBad.setOnClickListener {
            binding.vTabLine3.visibility = View.VISIBLE
            binding.vTabLine2.visibility = View.INVISIBLE
            binding.vTabLine1.visibility = View.INVISIBLE
        }
    }
}