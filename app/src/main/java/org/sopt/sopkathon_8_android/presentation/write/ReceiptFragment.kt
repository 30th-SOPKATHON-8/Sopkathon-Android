package org.sopt.sopkathon_8_android.presentation.write

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.sopt.sopkathon_8_android.R
import org.sopt.sopkathon_8_android.databinding.FragmentReceiptBinding


class ReceiptFragment : Fragment() {
    private var _binding :FragmentReceiptBinding ?=null
    private val binding:FragmentReceiptBinding get() = binding ?: error("binding이 연결안되었슴다.")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_receipt, container, false)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}