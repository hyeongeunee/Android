package com.example.hello2;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

/*
    이 MainActivity 는 hello2 앱이 실행(launch) 될 때
    최초로 사용자를 대면하는 액티비티이다.
    대체로 액티비티 하나는 화면 하나다.
 */
public class MainActivity extends AppCompatActivity {
    // 액티비티가 활성화될 때 최초 호출되는 메소드
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // res/layout/activity_main.xml 문서를 전개(해석) 해서 화면 구성하기
        setContentView(R.layout.activity_main);
    }

    // 버튼을 클릭했을 때 호출되는 메소드 (View 객체의 참조값이 매개 변수에 전달된다)
    public void clicked(View v) {
        Toast.makeText(this, "버튼을 눌렀네?", Toast.LENGTH_SHORT).show();
    }

    public void deleteClicked(View v) {
        Toast.makeText(this, "삭제합니다.", Toast.LENGTH_SHORT).show();
    }
}