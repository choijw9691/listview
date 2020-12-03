package com.didimstory.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText mAddressEdit;
    private WebView mWebview;
    private Button mMoveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //데이터 준비 d
        ArrayList<Weather> data=new ArrayList<>();

        data.add(new Weather("수원","25도","맑음"));
        data.add(new Weather("수원","25도","맑음"));
        data.add(new Weather("수원","25도","맑음"));
        data.add(new Weather("수원","25도","맑음"));

        //djeoqxj
        MyFristAdater adapter=new MyFristAdater(data);

        //뷰
        ListView listView = findViewById(R.id.list_view);
        listView.setAdapter(adapter);

        //클릭
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(MainActivity.this,position+"번재 아이템 선택",Toast.LENGTH_SHORT);

            }
        });

    }
}