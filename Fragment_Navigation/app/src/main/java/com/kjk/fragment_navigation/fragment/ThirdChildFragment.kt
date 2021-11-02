package com.kjk.fragment_navigation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.kjk.fragment_navigation.R
import com.kjk.fragment_navigation.databinding.FragmentThirdChildBinding

class ThirdChildFragment : Fragment(R.layout.fragment_third_child) {

    private var _binding: FragmentThirdChildBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentThirdChildBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.btnToMainFragment.setOnClickListener {
            findNavController().navigate(R.id.action_thirdChildFragment_to_mainFragment, bundleOf("key" to "jinkweon_ko"))
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}