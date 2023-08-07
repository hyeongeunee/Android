package com.example.step08gameview

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.os.Handler
import android.os.Message
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View

class GameView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : View(context, attrs) {

    lateinit var handler2: Handler

    // 사용할 필드를 미리 만들기
    lateinit var backImg: Bitmap
    lateinit var dragonImg1: Bitmap

    // 화면의 폭과 높이를 저장할 필드
    private var width = 0
    private var height = 0

    // 배경 이미지의 y 좌표
    var back1Y = 0
    var back2Y = 0

    // 유닛의 크기
    var unitSize = 0

    // 드래곤의 좌표
    var dragonX = 0
    var dragonY = 0

    // 게임 화면을 준비하는 함수
    fun init() {
        // 사용할 이미지를 미리 로딩해서 참조값을 필드에 저장하기
        // 원본 이미지
        var backImg: Bitmap = BitmapFactory.decodeResource(resources, R.drawable.backbg)
        // 원본 이미지를 원하는 크기로 변경해서 필드에 저장하기
        this.backImg = Bitmap.createScaledBitmap(backImg, width, height, false)
        var dragonImg1 = BitmapFactory.decodeResource(resources, R.drawable.unit1)
        this.dragonImg1 = Bitmap.createScaledBitmap(dragonImg1, unitSize, unitSize, false)

        // Handler 객체를 intit 블럭에서 생성해서 참조값을 필드에 넣어둔다.
        this.handler2 = object : Handler() {
            // Handler 객체에 메세지가 도착하면 호출되는 메소드
            override fun handleMessage(msg: Message) {
                // 화면 갱신하기
                invalidate()
                // handler 객체에 빈 메세지를 10/1000 초 이후에 다시 보내기
                sendEmptyMessageDelayed(0, 10)
            }
        }
        // Handler 객체에 빈 메세지를 한 번 보내기
        handler2.sendEmptyMessageDelayed(0, 20)
    }

    // onDraw() 메소드에서 화면 구성하기
    override fun onDraw(canvas: Canvas?) {
        // 배경 이미지, 유닛 이미지, 적군 이미지 등 그리기
        canvas?.drawBitmap(backImg, 0f, back1Y.toFloat(), null)
        canvas?.drawBitmap(backImg, 0f, back2Y.toFloat(), null)

        canvas?.drawBitmap(
            dragonImg1,
            (dragonX - unitSize / 2).toFloat(),
            (dragonY - unitSize / 2).toFloat(),
            null
        )

        // 배경 이미지 관련 처리
        back1Y += 5
        back2Y += 5
        // 만일 배경1 의 좌표가 아래로 벗어난다면
        if (back1Y >= height) {
            // 배경 1를 상단으로 다시 보낸다.
            back1Y = -height
            // 배경 2와 오차가 생기지 않게 하기 위해 복원하기
            back2Y = 0
        }
        // 만일 배경 2의 좌표가 아래로 벗어난다면
        if (back2Y >= height) {
            // 배경 2를 상단으로 다시 보낸다.
            back2Y = -height
            // 배경 1의 오차가 생기지 않게 하기 위해 복원하기
            back1Y = 0
        }
    }

    // View 가 차지하고 있는 영역의 width 와 height 가 전달되는 메소드
    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        // 전달되는 폭과 높이를 필드에 저장
        width = w
        height = h

        // 배경 이미지의 초기좌표
        back2Y = -height

        // unitSize 는 화면 폭의  1/5 로 설정
        unitSize = w / 5
        // 드래곤의 초기 좌표 부여
        dragonX = w / 2
        dragonY = height - unitSize / 2

        // 초기화 함수 호출
        init()
    }

    // View 에 터치 이벤트가 발생하면 호출되는 함수
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when (event?.action) {
            MotionEvent.ACTION_MOVE -> {
                // 이벤트가 일어난 곳의 x 좌표를 dragon 의 좌표에 반영하기
                dragonX = event.x.toInt()
            }
        }
        return true
    }
}