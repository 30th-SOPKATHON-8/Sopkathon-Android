package org.sopt.sopkathon_8_android.presentation.write

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.add
import androidx.fragment.app.commit
import org.sopt.sopkathon_8_android.R
import org.sopt.sopkathon_8_android.data.ResponsePost
import org.sopt.sopkathon_8_android.databinding.ActivityWriteBinding
import org.sopt.sopkathon_8_android.presentation.viewmodel.WriteViewModel

class WriteActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWriteBinding
    private val viewModel by viewModels<WriteViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWriteBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initFragmentContainerView()
    }

    private fun initFragmentContainerView() {
        if(!intent.getBooleanExtra("receipt", false)) {
            supportFragmentManager.commit {
                add<WriteFragment>(R.id.fcv_write, "WriteFragment")
            }
        } else {
            viewModel.setResponse(ResponsePost.Data(
                intent.getStringExtra("title") ?: "",
                intent.getStringExtra("price")?.removeSuffix(" Xcoin") ?: "",
                intent.getBooleanExtra("isXibal", false),
                intent.getStringExtra("content") ?: "",
                intent.getStringExtra("createdAt") ?: ""
            ))
            supportFragmentManager.commit {
                add<ReceiptFragment>(R.id.fcv_write, "ReceiptFragment")
            }
        }
    }
}