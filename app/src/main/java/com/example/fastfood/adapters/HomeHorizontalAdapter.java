package com.example.fastfood.adapters;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fastfood.R;
import com.example.fastfood.modules.HomeHorizontalModule;
import com.example.fastfood.modules.HomeVerticalModule;

import java.util.ArrayList;
import java.util.List;

public class HomeHorizontalAdapter extends RecyclerView.Adapter<HomeHorizontalAdapter.viewHolder> {
    UpdateVerticalRec updateVerticalRec;
    Activity activity;
    ArrayList<HomeHorizontalModule> list;
    boolean select = true;
    boolean check = true;
    int rowIndex = -1;

    public HomeHorizontalAdapter(UpdateVerticalRec updateVerticalRec,Activity activity,ArrayList<HomeHorizontalModule> list) {
        this.updateVerticalRec = updateVerticalRec;
        this.activity = activity;
        this.list = list;
    }




    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new viewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.home_horizontal,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder,int position) {
            int adapterposition = holder.getAdapterPosition();
            holder.imageView.setImageResource(list.get(position).getImage());
            holder.name.setText(list.get(position).getName());
            holder.cardView.setBackgroundResource(R.drawable.default_color);

        if(check) {
            ArrayList<HomeVerticalModule> homeVerticalModule = new ArrayList<>();
            homeVerticalModule.add(0, new HomeVerticalModule(R.drawable.bg4, "09.00 - 22.00", "Veggie Paradise", "4.9", "250 Rs"));
            homeVerticalModule.add(1, new HomeVerticalModule(R.drawable.bg5, "10.00 - 23.00", "Cheese Pizza", "4.7", "179 Rs"));
            homeVerticalModule.add(2, new HomeVerticalModule(R.drawable.bg6, "10.00 - 22.00", "Farmhouse", "4.8", "459 Rs"));
            updateVerticalRec.callback(adapterposition, homeVerticalModule);
            check = false;
        }
            holder.cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    rowIndex = adapterposition;
                    notifyDataSetChanged();

                    if(adapterposition == 0){
                        ArrayList<HomeVerticalModule> homeVerticalModule = new ArrayList<>();
                        homeVerticalModule.add(0,new HomeVerticalModule(R.drawable.bg4,"09.00 - 22.00","Veggie Paradise","4.9","250 Rs"));
                        homeVerticalModule.add(1,new HomeVerticalModule(R.drawable.bg5,"10.00 - 23.00","Cheese Pizza","4.7","179 Rs"));
                        homeVerticalModule.add(2,new HomeVerticalModule(R.drawable.bg6,"10.00 - 22.00","Farmhouse","4.8","459 Rs"));
                        updateVerticalRec.callback(adapterposition,homeVerticalModule);
                    }
                    else if (adapterposition == 1){
                        ArrayList<HomeVerticalModule> homeVerticalModule = new ArrayList<>();
                        homeVerticalModule.add(0,new HomeVerticalModule(R.drawable.bg2,"10.00 - 23.00","Aloo tikki Burger","4.7","110 Rs"));
                        homeVerticalModule.add(1,new HomeVerticalModule(R.drawable.bg1,"11.00 - 23.00","Veg Burger","4.5","123 Rs"));
                        homeVerticalModule.add(2,new HomeVerticalModule(R.drawable.bg3,"11.00 - 21.00","Maharaja Burger","4.9","150 Rs"));
                        updateVerticalRec.callback(adapterposition,homeVerticalModule);
                    }
                    else if (adapterposition == 2){
                        ArrayList<HomeVerticalModule> homeVerticalModule = new ArrayList<>();
                        homeVerticalModule.add(0,new HomeVerticalModule(R.drawable.ff1,"10.00 - 23.00","French Fries","4.7","70 Rs"));
                        homeVerticalModule.add(1,new HomeVerticalModule(R.drawable.ff2,"11.00 - 23.00","Peri Peri Fries","4.6","90 Rs"));
                        homeVerticalModule.add(2,new HomeVerticalModule(R.drawable.ff3,"11.00 - 21.00","Schezwan Fries","4.9","120 Rs"));
                        updateVerticalRec.callback(adapterposition,homeVerticalModule);
                    }
                    else if (adapterposition == 3){
                        ArrayList<HomeVerticalModule> homeVerticalModule = new ArrayList<>();
                        homeVerticalModule.add(0,new HomeVerticalModule(R.drawable.sw1,"10.00 - 22.00","Vegetable Sandwich","4.7","45 Rs"));
                        homeVerticalModule.add(1,new HomeVerticalModule(R.drawable.sw2,"12.00 - 23.00","Chocolate Sandwich","4.6","55 Rs"));
                        homeVerticalModule.add(2,new HomeVerticalModule(R.drawable.sw3,"11.00 - 22.00","Cheese Sandwich","5.0","35 Rs"));
                        updateVerticalRec.callback(adapterposition,homeVerticalModule);
                    }
                    else if (adapterposition == 4){
                        ArrayList<HomeVerticalModule> homeVerticalModule = new ArrayList<>();
                        homeVerticalModule.add(0,new HomeVerticalModule(R.drawable.ic1,"15.00 - 23.00","Chocolate Icecream","5.0","110 Rs"));
                        homeVerticalModule.add(1,new HomeVerticalModule(R.drawable.ic2,"16.00 - 23.00","Strawberry Icecream","4.7","90 Rs"));
                        homeVerticalModule.add(2,new HomeVerticalModule(R.drawable.ic3,"19.00 - 21.00","RajBhog Icecream","4.9","150Rs"));
                        updateVerticalRec.callback(adapterposition,homeVerticalModule);
                    }

                }
                });
            if(select){
                if(adapterposition==0){
                    holder.cardView.setBackgroundResource(R.drawable.onclick_backgroundchange);
                    select=false;
                }
            }
            else{
                if(rowIndex==adapterposition){
                    holder.cardView.setBackgroundResource(R.drawable.onclick_backgroundchange);
                }
                else {
                    holder.cardView.setBackgroundResource(R.drawable.default_color);
                }
            }
            }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView name;
        CardView cardView;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.hori_image);
            name = itemView.findViewById(R.id.hori_txt);
            cardView = itemView.findViewById(R.id.cardView);

        }
    }
}
