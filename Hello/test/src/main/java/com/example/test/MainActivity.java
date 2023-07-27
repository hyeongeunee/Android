package com.example.test;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText inputNum = findViewById(R.id.inputNum);
        Button testBtn = findViewById(R.id.testBtn);

        testBtn.setOnClickListener(view -> {
            String numStr = inputNum.getText().toString();
            int num = Integer.parseInt(numStr);
            String message;
            if (num % 2 == 0) {
                message = "짝수입니다";
            } else {
                message = "홀수입니다";
            }
            showToast(message);
        });
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}