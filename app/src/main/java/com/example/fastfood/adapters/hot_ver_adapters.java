package com.example.fastfood.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fastfood.R;
import com.example.fastfood.modules.hot_ver_models;
import com.example.fastfood.modules.meal_item_menu;

import java.util.List;

public class hot_ver_adapters extends RecyclerView.Adapter<hot_ver_adapters.ViewHolder> {
    List<hot_ver_models> list;

    public hot_ver_adapters(List<hot_ver_models> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public hot_ver_adapters.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.hot_ver_view,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull hot_ver_adapters.ViewHolder holder, int position) {
        holder.image.setImageResource(list.get(position).getImage());
        holder.name.setText(list.get(position).getName());
        holder.description.setText(list.get(position).getDescription());
        holder.price.setText(list.get(position).getPrice());
        holder.rating.setText(list.get(position).getRating());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView name;
        TextView description;
        TextView price;
        TextView rating;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.menu_image);
            name = itemView.findViewById(R.id.name);
            description = itemView.findViewById(R.id.descr);
            price = itemView.findViewById(R.id.meal_price);
            rating = itemView.findViewById(R.id.rating);
        }
    }
}
