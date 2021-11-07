package com.kjk.lifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.TextView
import com.kjk.lifecycle.databinding.ActivityMainBinding

/**
 *
 *  Activity의 수명 주기 관련 callBack()
 *  - onCreate()
 *  - onStart()
 *  - onResume()
 *  - onPause()
 *  - onStop()
 *  - onDestroy()
 */
class MainActivity : AppCompatActivity() {

    // View Binding
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    /**
     *  - Activity를 생성할 때 실행.
     *  - 필수적으로 구현.
     *  - Activity의 전체 수명 주기 동안, 한 번만 발생해야하는 기본 애플리케이션 시작 로직 실행.
     *   ex) 1. data를 목록에 binding,
     *       2. Activity를 ViewModel과 연결.
     *       3. 일부 클래스 범위 변수의 instance화.
     *
     *  - savedInstanceState : Activity의 이전 저장 상태가 포함된 Bundle객체.
     *                         이번에 처음 생성된 Activity인 경우, Bundle == null
     *
     *  Activity의 수명 주기와 연결된 '수명 주기 인식 구성요소'가 있다면,
     *  이 구성 요소는 ON_CREATE 이벤트를 수신.
     *  따라서, @OnLifeCycleEvent라는 주석이 있는 메소드가 호출.
     *  '수명 주기 인식 구성요소'는 '생성됨' 상태에 필요한 모든 설정 코드를 실행.
     */
    // transient state : 시스템의 시간이 지남에 따라 반
    private var gameState: String? = null
    private var GAME_STATE_KEY: String = "GAME_KEY"
    private var TEXT_VIEW_KEY: String = "TEXT_KEY"
    override fun onCreate(savedInstanceState: Bundle?) {
        //
        super.onCreate(savedInstanceState)
        Log.w("1111", "OnCreate()")

        //
        gameState = savedInstanceState?.getString(GAME_STATE_KEY)

        // 해당 Activity의 layout을 set한다.
        setContentView(binding.root)

        // 이후, layout파일의 속성들을 사용한다.
        Log.w("1111_layout", binding.helloTextview.toString())
    }

    /**
     *  - onSavedInstanceState()를 사용하여, 이전에 saved instance를 저장한 경우가 있을 때에만
     *   호출된다.
     *  - onCreate()에서 몇몇 상태를 복구할 수 있다.
     */
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        binding.helloTextview.text = savedInstanceState?.getString(TEXT_VIEW_KEY)
    }

    override fun onSaveInstanceState(outState: Bundle) {

        outState?.run {
            putString(GAME_STATE_KEY, gameState)
            putString(TEXT_VIEW_KEY, binding.helloTextview.toString())
        }

        super.onSaveInstanceState(outState)
    }

    override fun onStart() {
        super.onStart()
        Log.w("1111", "onStart()")
    }

    override fun onResume() {
        super.onResume()
        Log.w("1111", "onResume()")
    }

    override fun onPause() {
        super.onPause()
        Log.w("1111", "onPause()")
    }

    override fun onStop() {
        super.onStop()
        Log.w("1111", "onStop()")
    }

    override fun onRestart() {
        super.onRestart()
        Log.w("1111", "onRestart()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.w("1111", "onDestroy()")
    }
}
















