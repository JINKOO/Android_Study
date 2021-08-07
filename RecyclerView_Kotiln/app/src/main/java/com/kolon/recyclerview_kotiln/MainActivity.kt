package com.kolon.recyclerview_kotiln

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.kolon.recyclerview_kotiln.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // 전역 변수로 바인딩 객체 선언
    private var mBinding: ActivityMainBinding? = null

    // 매번 null check를 하지 않도록 바인딩 변수 선언
    private val binding get() = mBinding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val profileList = arrayListOf<Profiles>(
            Profiles(R.drawable.man, "고진권", 29, "코오롱베니트 안드로이드 앱 개발자"),
            Profiles(R.drawable.woman, "박서영", 25, "코오롱베니트 서버 개발자"),
            Profiles(R.drawable.man, "박성준", 29, "농협 은행 개발자"),
            Profiles(R.drawable.man, "박지상", 28, "스타트업 안드로이드 앱 개발자"),
            Profiles(R.drawable.man, "정구일", 29, "수협은행 안드로이드 앱 개발자"),
            Profiles(R.drawable.man, "김형택", 28, "넷바블 스프링 개발자"),
            Profiles(R.drawable.man, "고진권", 30, "안드로이드 앱 개발자"),
            Profiles(R.drawable.man, "고진권", 31, "안드로이드 앱 개발자"),
            Profiles(R.drawable.man, "고진권", 32, "안드로이드 앱 개발자"),
            Profiles(R.drawable.woman, "고진권", 33, "안드로이드 앱 개발자"),
            Profiles(R.drawable.man, "고진권", 34, "안드로이드 앱 개발자"),
            Profiles(R.drawable.woman, "고진권", 35, "안드로이드 앱 개발자"),
            Profiles(R.drawable.man, "고진권", 36, "안드로이드 앱 개발자"),
            Profiles(R.drawable.man, "고진권", 37, "안드로이드 앱 개발자")
        )

        binding.rvProfile.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rvProfile.setHasFixedSize(true) // 리사이클러 뷰에 대한 성능 개선 방안

        // 이제 본격적으로 우리가 만든 adapter를 최초 생성해서 연결
        binding.rvProfile.adapter = ProfileAdapter(profileList)
    }
}