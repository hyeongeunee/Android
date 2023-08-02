package com.example.step07sqlite2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

// 대표 생성자 정의 (선언하는 것만으로 필드가 만들어지고 전달된 값이 필드에 저장된다)
class TodoAdapter constructor(
    var context: Context,
    val layoutRes: Int, var list: List<Todo>
) : BaseAdapter() { // BaseAdapter 추상 클래스 상속

    // 전체 모델의 개수 리턴
    override fun getCount(): Int {
        return list.size
    }

    // i 번째 인덱스의 모델 리턴
    override fun getItem(i: Int): Any {
        return list[i] // 배열처럼 사용 가능
    }

    // i 번째 인덱스의 pk 값
    override fun getItemId(i: Int): Long {
        return list[i].num as Long
//        return list.get(i).num.toLong()
    }

    // 코틀린의 매개 변수는 기본값이 val 이다. 즉 상수라서 재할당이 불가능하다.
    override fun getView(postition: Int, view: View?, viewGroup: ViewGroup?): View {
        var resultView: View = if (view == null) { // view 가 만일 null 이면
            // 레이아웃 전개자 객체를 이용해서 View 를 새로 만든 값을 대입
            LayoutInflater.from(context).inflate(layoutRes, viewGroup, false)
        } else {
            // 매개변수에 전달된 참조값을 대입
            view
        }
        // position 에 해당하는 Todo 객체를 얻어와서
        val tmp = list[postition]
        // 할 일 정보를 출력한다.
        val text_content = resultView.findViewById<TextView>(R.id.text_content)
        text_content.text = tmp.content
        // 위의 작업을 apply 를 이용하면 아래처럼 처리할 수도 있다.
        resultView.findViewById<TextView>(R.id.text_regdate).apply {
            text = tmp.regdate
        }
        return resultView
    }
}