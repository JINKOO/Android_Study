package com.kjk.fragment_navigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import androidx.navigation.fragment.NavHostFragment
import com.kjk.fragment_navigation.databinding.ActivityMainBinding
import com.kjk.fragment_navigation.fragment.FirstFragment
import com.kjk.fragment_navigation.fragment.MainFragment

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        /** XML에서 fragment를 지정하지 않고 하는 방법*/
        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<MainFragment>(R.id.nav_host_fragment)
            }
        }


        /** */
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

    }

    override fun onClick(v: View?) {
        when(v) {
//            binding.btnReplaceFragment -> replaceFragment()
        }
    }

    /** fragment를 교체하는데, backstack에 쌓인 모든 fragment를 제거하고, 현재 fragment containerId에 추가된
     *  fragment로 교체한다.
     *  즉, 동작 원리는 현재까지 added된 fragment remove, 현재 fragment를 add*/
    private fun replaceFragment() {
        Log.w("1111", "clicked")
        supportFragmentManager.commit {
            replace<FirstFragment>(R.id.nav_host_fragment)
            setReorderingAllowed(true)
            addToBackStack(null)
        }
    }
}