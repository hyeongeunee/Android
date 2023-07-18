package com.example.step01activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // 카운트를 셀 필드
    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main);
    }

    // 버튼을 클릭했을 때 실행되는 메소드
    public void clicked(View v) {
        // 필드의 값을 1증가 시키기
        count++;
        // 필드의 값을 TextView 에 출력하기
        // (res/layout/activty_main.xml 문서를 전개해서 레이아웃을 구성했는데
        // 거기에 TextView 의 참조값을 얻어와야 한다.
        TextView a = findViewById(R.id.textView);
        a.setText(Integer.toString(count));
    }
}