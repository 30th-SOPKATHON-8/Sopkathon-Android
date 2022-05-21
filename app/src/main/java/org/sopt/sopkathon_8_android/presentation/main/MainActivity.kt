package org.sopt.sopkathon_8_android.presentation.main

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import org.sopt.sopkathon_8_android.databinding.ActivityMainBinding
import org.sopt.sopkathon_8_android.presentation.viewmodel.MainViewModel
import org.sopt.sopkathon_8_android.presentation.write.WriteActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val adapter = MainItemAdapter {
        val intent = Intent(this, WriteActivity::class.java).apply {
            putExtra("receipt", true)
            putExtra("isXibal", it.isXibal)
            putExtra("title", it.title)
            putExtra("price", it.price)
            putExtra("content", it.content)
            putExtra("createdAt", it.createdAt)
        }
        startActivity(intent)
    }
    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.viewmodel = viewModel
        binding.lifecycleOwner = this
        setContentView(binding.root)

        viewModel.getTotalInfo()
        viewModel.getList(viewModel.category)
        initRecyclerView()
        clickAll()
        clickGood()
        clickBad()
        clickWrite()
        observeData()
    }

    override fun onRestart() {
        super.onRestart()
        viewModel.getList(viewModel.category)
        viewModel.getTotalInfo()
    }

    private fun initRecyclerView() {
        binding.rvMain.adapter = adapter
        adapter.notifyDataSetChanged()
    }

    private fun clickWrite() {
        binding.ivWrite.setOnClickListener {
            val intent = Intent(this, WriteActivity::class.java)
            startActivity(intent)
        }
    }

    private fun clickAll() {
        binding.tvTotal.setOnClickListener {
            binding.vTabLine1.visibility = View.VISIBLE
            binding.vTabLine2.visibility = View.INVISIBLE
            binding.vTabLine3.visibility = View.INVISIBLE
            viewModel.category = "all"
            viewModel.getList(viewModel.category)
        }
    }

    private fun clickGood() {
        binding.tvGood.setOnClickListener {
            binding.vTabLine2.visibility = View.VISIBLE
            binding.vTabLine1.visibility = View.INVISIBLE
            binding.vTabLine3.visibility = View.INVISIBLE
            viewModel.category = "bad"
            viewModel.getList(viewModel.category)
        }
    }

    private fun clickBad() {
        binding.tvBad.setOnClickListener {
            binding.vTabLine3.visibility = View.VISIBLE
            binding.vTabLine2.visibility = View.INVISIBLE
            binding.vTabLine1.visibility = View.INVISIBLE
            viewModel.category = "good"
            viewModel.getList(viewModel.category)
        }
    }

    private fun observeData() {
        viewModel.list.observe(this) {
            adapter.replaceItem(it)
        }
    }
}