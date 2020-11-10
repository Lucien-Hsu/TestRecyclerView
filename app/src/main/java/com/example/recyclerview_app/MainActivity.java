package com.example.recyclerview_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Context context;
    private RecyclerView recyclerViewData;
    private MyStaggerAdapter staggerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;

        //1.建立資料
        List<String> listString = new ArrayList<String>();
        for(int i = 0 ; i < 30; i++){
            String data = new String("Item : " + (i + 1));
            Log.d("mTest", "data = " + data);
            listString.add(data);
        }

        //2.取得元件
        recyclerViewData = findViewById(R.id.recyclerView_data);

        //3.建立LayoutManager
        //3-1.提供LayoutManager相關參數
        //引數一為欄位數
        //引數二為垂直或水平
        StaggeredGridLayoutManager mLayoutManager_stagger = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        //3-2.設置LayoutManager
        recyclerViewData.setLayoutManager(mLayoutManager_stagger);

        //4.建立自定義適配器
        staggerAdapter = new MyStaggerAdapter(context, listString);
        //5.連接適配器
        recyclerViewData.setAdapter(staggerAdapter);
    }
}