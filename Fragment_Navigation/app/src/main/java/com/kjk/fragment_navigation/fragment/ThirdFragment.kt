package com.kjk.fragment_navigation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.kjk.fragment_navigation.R
import com.kjk.fragment_navigation.databinding.FragmentThirdBinding

class ThirdFragment : Fragment(R.layout.fragment_third) {

    private var _binding: FragmentThirdBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentThirdBinding.inflate(inflater, container, false)

        val view = binding.root
        binding.btnThirdChild.setOnClickListener {
            findNavController().navigate(ThirdFragmentDirections.actionThirdFragmentToThirdChildFragment())
        }
        return view
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}