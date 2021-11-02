package com.kjk.fragment_navigation.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.kjk.fragment_navigation.R
import com.kjk.fragment_navigation.databinding.FragmentMainBinding

class MainFragment : Fragment(R.layout.fragment_main), View.OnClickListener {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!  // !! -> nullable로 설정된 property를 강제로 not null로 바꿔준다.

    /** 레이아웃을 inflate하여, view를 생성한다. */
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater,container, false)
        val view = binding.root

        binding.btnFirstFragment.setOnClickListener(this)
        binding.btnSecondFragment.setOnClickListener(this)
        binding.btnThirdFragment.setOnClickListener(this)

        return view
    }

    override fun onClick(p0: View?) {
        when(p0) {
            binding.btnFirstFragment -> {
                Log.w("1111", "clicked")
                val actions = MainFragmentDirections.actionMainFragmentToFirstFragment()
                binding.btnFirstFragment.apply {
                    findNavController().navigate(actions)
                }
            }

            binding.btnSecondFragment -> {
                binding.btnSecondFragment.apply {
                    findNavController().navigate(MainFragmentDirections.actionMainFragmentToSecondFragment())
                }
            }

            binding.btnThirdFragment -> {
                findNavController().navigate(R.id.action_mainFragment_to_ThirdFragment)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}