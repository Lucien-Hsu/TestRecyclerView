package com.example.recyclerview_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private Context context;

    private RecyclerView recyclerViewData;
    private MyStaggerAdapter staggerAdapter;

    private int[] pictureNumber = {
            R.drawable.img_1,
            R.drawable.img_2,
            R.drawable.img_3,
            R.drawable.img_4,
            R.drawable.img_5,
            R.drawable.img_6,
            R.drawable.img_7,
            R.drawable.img_8,
            R.drawable.img_9,
            R.drawable.img_10,
            R.drawable.img_11
    };

    private List<Map<String, Object>> pictureList;
    private RecyclerView recyclerViewPicture;

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

        //=======第二個recyclerView======
        //準備資料
        pictureList = new ArrayList<Map<String, Object>>();
        for(int i = 0 ; i < pictureNumber.length ; i++){
            Map<String, Object> data = new HashMap<String, Object>();
            data.put("image", pictureNumber[i]);
            pictureList.add(data);
        }
        //取得元件
        recyclerViewPicture = findViewById(R.id.recyclerView_pic);
        //建立LayoutManager
        LinearLayoutManager mlinearLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewPicture.setLayoutManager(mlinearLayoutManager);
        //建立自定義適配器
        MyLinearAdapter linearAdapter = new MyLinearAdapter(context, pictureList);
        //連接適配器
        recyclerViewPicture.setAdapter(linearAdapter);


    }
}