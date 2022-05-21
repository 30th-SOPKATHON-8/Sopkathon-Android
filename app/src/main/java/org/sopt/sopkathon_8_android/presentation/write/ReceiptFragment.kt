package org.sopt.sopkathon_8_android.presentation.write

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.sopt.sopkathon_8_android.databinding.FragmentReceiptBinding


class ReceiptFragment : Fragment() {
    private var _binding: FragmentReceiptBinding? = null
    private val binding: FragmentReceiptBinding get() = _binding ?: error("binding이 연결안되었슴다.")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentReceiptBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setOnInputClickEvent()
    }


    private fun setOnInputClickEvent() {
        binding.btnConfirm.setOnClickListener {
            requireActivity().finish()  //프레그먼트가 있는 activity를 종료
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}