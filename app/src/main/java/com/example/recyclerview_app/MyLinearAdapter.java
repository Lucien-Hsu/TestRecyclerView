package com.example.recyclerview_app;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Map;

public class MyLinearAdapter extends RecyclerView.Adapter<MyLinearAdapter.ViewHolder> {
    private final Context context;
    private final List<Map<String, Object>> mList;
    LayoutInflater mInflater;
    ImageView imageViewMain;

    public MyLinearAdapter(Context context, List<Map<String, Object>> mList, ImageView imageViewMain) {
        this.context = context;
        this.mList = mList;
        this.imageViewMain = imageViewMain;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView_picture);

            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //設定點擊後將圖片顯示在下方
                    //設定圖片不可見
                    imageViewMain.setVisibility(View.VISIBLE);
                    //取出索引值
                    int index = (int)imageView.getTag();
                    Map<String, Object> mdata = mList.get(index);
                    int number = (int) mdata.get("image");
                    imageViewMain.setImageResource(number);
                }
            });
        }
    }

    @NonNull
    @Override
    public MyLinearAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.picture_layout, null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyLinearAdapter.ViewHolder holder, int position) {
        holder.imageView.setImageResource((Integer) mList.get(position).get("image"));
        //附加索引值
        holder.imageView.setTag(position);
    }
}
