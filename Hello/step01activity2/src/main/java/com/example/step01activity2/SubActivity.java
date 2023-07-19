package com.example.step01activity2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class SubActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
        // 디버깅 로그 출력하기 Log.d("꼬리표", "메세지")
        Log.d("SubActivity", "onCreate()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("SubActivity", "onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("SubActivity", "onResume()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("SubActivity", "onRestart()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("SubActivity", "onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("SubActivity", "onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("SubActivity", "onDestroy()");
    }
}