package org.sopt.sopkathon_8_android.presentation.write

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.add
import androidx.fragment.app.commit
import org.sopt.sopkathon_8_android.R
import org.sopt.sopkathon_8_android.databinding.ActivityWriteBinding

class WriteActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWriteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initFragmentContainerView()
    }

    private fun initFragmentContainerView() {
        supportFragmentManager.commit {
            add<WriteFragment>(R.id.fcv_write, "WriteFragment")
        }
    }
}