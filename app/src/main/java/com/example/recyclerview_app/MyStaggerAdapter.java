package com.example.recyclerview_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

//4.建立自定義適配器
//適配器需繼承RecyclerView.Adapter
//需實作三個必要方法
public class MyStaggerAdapter extends RecyclerView.Adapter<MyStaggerAdapter.ViewHolder> {
    private final Context context;
    private final List<String> mListString;
    private final LayoutInflater mLayoutInflater;

    //4-1.建構子
    //取得context與資料，並設定一個Inflater填充於傳來的context中
    public MyStaggerAdapter(Context context, List<String> listString) {
        this.context = context;
        mListString = listString;
        mLayoutInflater = LayoutInflater.from(context);
    }

    //4-2.取得項目數量
    @Override
    public int getItemCount() {
        //回傳資料數
        return mListString.size();
    }

    //4-3.建立ViewHolder內部類別，必須繼承RecyclerView.ViewHolder
    public class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView imageView_data;
        private final TextView textView_data;
        //取得項目視圖中的ViewID
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView_data = itemView.findViewById(R.id.imageView_data);
            textView_data = itemView.findViewById(R.id.textView_data);

            //監聽器
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context, textView_data.getText().toString(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    //4-4.建立ViewHolder
    @NonNull
    @Override
    public MyStaggerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //填充項目View
        View view = mLayoutInflater.inflate(R.layout.data_layout, null);
        //建立ViewHolder實體
        //此處會把已填充的view給viewHolder，由viewHolder把內部的viewID取出
        ViewHolder viewHolder = new ViewHolder(view);
        //回傳viewHolder
        return viewHolder;
    }

    //4-5.將資料連接到ViewHolder
    @Override
    public void onBindViewHolder(@NonNull MyStaggerAdapter.ViewHolder holder, int position) {
        holder.textView_data.setText(mListString.get(position));
        holder.imageView_data.setImageResource(android.R.drawable.btn_star_big_on);
    }
}
