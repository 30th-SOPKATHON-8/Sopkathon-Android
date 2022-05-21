package org.sopt.sopkathon_8_android.presentation.write

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import org.sopt.sopkathon_8_android.R
import org.sopt.sopkathon_8_android.databinding.FragmentWriteBinding
import org.sopt.sopkathon_8_android.presentation.viewmodel.WriteViewModel

class WriteFragment : Fragment() {
    private var _binding: FragmentWriteBinding? = null
    private val binding get() = _binding ?: error("binding not initialized")
    private val viewModel by activityViewModels<WriteViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding =
            DataBindingUtil.inflate(layoutInflater, R.layout.fragment_write, container, false)
        binding.viewmodel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)

        observeLiveData()
        clickSubmit()
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    private fun observeLiveData() {
        viewModel.isXibal.observe(viewLifecycleOwner) {
            when(it) {
                true -> {
                    binding.ivGoodXibal.imageTintList = ColorStateList.valueOf(Color.parseColor("#aaeeeeee"))
                    binding.ivBadXibal.imageTintList = null
                }
                false -> {
                    binding.ivGoodXibal.imageTintList = null
                    binding.ivBadXibal.imageTintList = ColorStateList.valueOf(Color.parseColor("#aaeeeeee"))
                }
            }
        }
    }

    private fun clickSubmit() {
        binding.tvSubmit.setOnClickListener {
            parentFragmentManager.commit {
                replace<ReceiptFragment>(R.id.fcv_write)
            }
        }
    }
}