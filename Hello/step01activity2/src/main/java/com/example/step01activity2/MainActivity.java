package com.example.step01activity2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

// activity = context type
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 이동 버튼의 참조값 얻어오기
        Button moveBtn = findViewById(R.id.moveBtn);
        // 버튼을 눌렀을 때 동작하기 위한 리스너 등록
        moveBtn.setOnClickListener(this);
        // 여기서 this 는 MainActivity 를 가리키고 type 은 View.OnClickListener 이다.
        // document.querySelector("#moveBtn").addEventListener("click", ()=>{}) 와 같은 역할

//        View.OnClickListener listner = new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        };
//        moveBtn.setOnClickListener(listner);

        // 메소드 하나짜리는 이렇게도 가능 !
//        moveBtn.setOnClickListener(v->{
//            // SubActivity 를 활성화 시키겠다는 의도(Intent) 객체 생성하기
//            Intent intent = new Intent(this, SubActivity.class);
//            // startActivity() 메소드를 호출하면서 Intent 객체를 전달하기
//            startActivity(intent);
//        });
    }

    // 안드로이드 4대 컴포넌트
    // 1. Activity 2. Service 3. BroadcastReceiver 4. Content Provider
    @Override
    public void onClick(View view) {
        // SubActivity 를 활성화 시키겠다는 의도(Intent) 객체 생성하기
        Intent intent = new Intent(this, SubActivity.class);
        // startActivity() 메소드를 호출하면서 Intent 객체를 전달하기
        startActivity(intent);
    }
}