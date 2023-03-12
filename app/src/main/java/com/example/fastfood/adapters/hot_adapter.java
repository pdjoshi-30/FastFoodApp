package com.example.fastfood.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fastfood.R;
import com.example.fastfood.modules.hot_model;
import com.example.fastfood.modules.meal_item_menu;

import java.util.List;

public class hot_adapter extends RecyclerView.Adapter<hot_adapter.ViewHolder> {
    List<hot_model> list;

    public hot_adapter(List<hot_model> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public hot_adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.hot_items,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull hot_adapter.ViewHolder holder, int position) {
        holder.hotImage.setImageResource(list.get(position).getImage());
        holder.name.setText(list.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView hotImage;
        TextView name;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            hotImage = itemView.findViewById(R.id.hot_image);
            name = itemView.findViewById(R.id.hot_name);
        }
    }
}
