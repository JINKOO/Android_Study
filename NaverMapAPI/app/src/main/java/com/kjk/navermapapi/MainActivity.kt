package com.kjk.navermapapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.annotation.UiThread
import com.kjk.navermapapi.databinding.ActivityMainBinding
import com.naver.maps.geometry.LatLng
import com.naver.maps.map.*
import com.naver.maps.map.util.FusedLocationSource

class MainActivity : AppCompatActivity(), OnMapReadyCallback {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    //TODO github에 push할 때, ID값 지우고 올리기
    private val CLIENT_ID = ""

    //
    private lateinit var locationSource: FusedLocationSource
    private lateinit var naverMap: NaverMap


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        NaverMapSdk.getInstance(this).client = NaverMapSdk.NaverCloudPlatformClient(CLIENT_ID)

        // LatLng 하나의 위경도 좌표를 나타내는 클래스, 좌표계 종류 중 하나이다.
        val coord = LatLng(37.5670135, 126.9783740)
        Log.w("1111", "위도: ${coord.latitude}, 경도: ${coord.longitude}")

        //
        val fm = supportFragmentManager
        val mapFragment = fm.findFragmentById(R.id.map_fragment) as MapFragment?
            ?: MapFragment.newInstance().also {
                fm.beginTransaction().add(R.id.map_fragment, it).commit()
            }

        // mapReady
        mapFragment.getMapAsync(this)

        //
        locationSource = FusedLocationSource(this, LOCATION_PERMISSION_REQUEST_CODE)

    }

    @UiThread
    override fun onMapReady(naverMap: NaverMap) {
        Log.w("1111", "onMapReady")
        this.naverMap = naverMap
        naverMap.locationSource = locationSource

        // 위치 추적 모드 사용.
        naverMap.locationTrackingMode = LocationTrackingMode.Follow

        // '현 위치' 버튼 컨트롤 사용. 사용자의 클릭에 따라 위치 추적 모드를 변경 할 수 있다.
        naverMap.uiSettings.isLocationButtonEnabled = true
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        Log.w("1111", "request Permission")
        if (locationSource.onRequestPermissionsResult(requestCode, permissions, grantResults)) {
            if (!locationSource.isActivated) { // 권한 거부됨
                naverMap.locationTrackingMode = LocationTrackingMode.None
            }
            return
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

    companion object {
        private const val LOCATION_PERMISSION_REQUEST_CODE = 1000
    }
}