package com.example.step02listview;

import android.app.AlertDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {
    // 필드 선언
    List<String> names;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ListView 의 참조값
        ListView listView = findViewById(R.id.listView);

        // ListView 에 출력할 sampleData
        names = new ArrayList<>();
        names.add("김구라");
        names.add("해골");
        names.add("원숭이");
        for (int i = 0; i < 100; i++) {
            names.add("아무게" + i);
        }

        // ListView 에 연결할 어댑터 객체
        // new ArrayAdapter<>( Context, Layout resource, 모델 )
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                names
        );
        // 어댑터를 ListView 에 연결하기
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(this);

        listView.setOnItemLongClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        // i 는 클릭한 Item 의 인덱스 값
        Log.d("MainActivity", "i:" + i);
        // 클릭한 Item 에 출력된 이름
        String clickedName = names.get(i);
        // 토스트 (가벼운 메세지) 출력
        Toast.makeText(this, clickedName, Toast.LENGTH_SHORT).show();
    }

    // ListView 의 cell 을 오랫동안 클릭하면 호출되는 메소드
    @Override
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
        new AlertDialog.Builder(this)
                .setTitle("알림")
                .setMessage("오래 클릭했네?")
                .setNeutralButton("확인", null)
                .create()
                .show();

        return false;
    }
}