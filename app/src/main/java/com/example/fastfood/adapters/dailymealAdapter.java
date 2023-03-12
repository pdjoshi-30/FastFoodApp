package com.example.fastfood.adapters;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fastfood.R;
import com.example.fastfood.daily_menu_Activity;
import com.example.fastfood.modules.dailymealModel;

import java.util.List;

public class dailymealAdapter extends RecyclerView.Adapter<dailymealAdapter.viewHolder> {
    Context context;
    List<dailymealModel> list;

    public dailymealAdapter(Context context,List<dailymealModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public dailymealAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new viewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.daily_meal_des,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull dailymealAdapter.viewHolder holder, int position) {
        holder.imageView.setImageResource(list.get(position).getImage());
        holder.name.setText(list.get(position).getName());
        holder.Description.setText(list.get(position).getDescription());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, daily_menu_Activity.class);
                intent.putExtra("type",list.get(holder.getAdapterPosition()).getType());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView name;
        TextView Description;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.dinner);
            name = itemView.findViewById(R.id.textView7);
            Description = itemView.findViewById(R.id.desc);
        }
    }
}
