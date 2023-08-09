package com.example.step08gameview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class GameActivity : AppCompatActivity() {
    // 사운드 매니저 객체
    lateinit var sManager: SoundManager

    // 클래스명에 . 찍어서 바로 참조할 수 있는 동반 객체에 상수값을 정의해 놓기
    companion object {
        val SOUND_LASER: Int = 0
        val SOUND_SHOOT: Int = 1
        val SOUND_DIE: Int = 2
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // GameView 객체를 생성해서 참조값을 변수에 담기
        val gameView = GameView(this)
        // GameView 로 화면을 채우기
        setContentView(gameView)
        // SoundManager 객체를 생성해서 필드에 저장하기
        sManager = SoundManager(this)
        // GameView 의 필드에 SoundManager 객체 넣어주기
        gameView.sManager = sManager
    }

    override fun onStart() {
        super.onStart()
        // 효과음 미리 로딩
        with(sManager) {
            addSound(SOUND_LASER, R.raw.laser1)
            addSound(SOUND_SHOOT, R.raw.shoot1)
            addSound(SOUND_DIE, R.raw.birddie)
        }
    }

    override fun onStop() {
        super.onStop()
        // 자원 해제
        sManager.release()
    }
}