package com.example.recyclerview_app;

import android.content.Context;
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

    public MyLinearAdapter(Context context, List<Map<String, Object>> mList) {
        this.context = context;
        this.mList = mList;
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
    }
}
