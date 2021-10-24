package com.kjk.navigation_aac_sample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.kjk.navigation_aac_sample.databinding.FragmentTitleScreenBinding

/**
 *  main title을 보여주는 Fragment
 */
class TitleScreen : Fragment(), View.OnClickListener{

    private var _binding: FragmentTitleScreenBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentTitleScreenBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.playBtn.setOnClickListener(this)
        binding.leaderboardBtn.setOnClickListener(this)

        return view
    }

    override fun onClick(p0: View?) {
        when (p0) {
            binding.playBtn -> {

            }

            binding.leaderboardBtn -> {

            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}