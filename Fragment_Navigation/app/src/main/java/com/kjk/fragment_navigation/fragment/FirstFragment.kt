package com.kjk.fragment_navigation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.kjk.fragment_navigation.R
import com.kjk.fragment_navigation.databinding.FragmentFirstBinding

class FirstFragment : Fragment(R.layout.fragment_first) {

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}