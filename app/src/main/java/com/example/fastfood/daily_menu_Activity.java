package com.example.fastfood;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.fastfood.adapters.meal_item_adapter;
import com.example.fastfood.modules.meal_item_menu;

import java.util.ArrayList;
import java.util.List;

public class daily_menu_Activity extends AppCompatActivity {
    RecyclerView recyclerView;
    ImageView imageView;
    List<meal_item_menu> meal_item_menu_list;
    meal_item_adapter   meal_item_adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_menu);
        String type = getIntent().getStringExtra("type");
        recyclerView = findViewById(R.id.meal_Rec);
        imageView = findViewById(R.id.barBreakfast);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        meal_item_menu_list = new ArrayList<>();
        meal_item_adapter = new meal_item_adapter(meal_item_menu_list);
        recyclerView.setAdapter(meal_item_adapter);

        if(type != null  &&  type.equalsIgnoreCase("breakfast")){
            meal_item_menu_list.add(new meal_item_menu(R.drawable.bf1,"Tea Doughnuts","Chocolate Overload","4.5","10.00-11.30","55 Rs"));
            meal_item_menu_list.add(new meal_item_menu(R.drawable.bf2,"StrawBan Oats","No sugar","4.3","09.00-12.30","105 Rs"));
            meal_item_menu_list.add(new meal_item_menu(R.drawable.bf3,"Burger Fries","Yummy","4.7","09.00-11.30","80 Rs"));
            meal_item_menu_list.add(new meal_item_menu(R.drawable.bf4,"MayoFry","Mayo Lovers please","4.9","09.00-11.00","75 Rs"));
            meal_item_adapter.notifyDataSetChanged();
        }
        if(type != null  &&  type.equalsIgnoreCase("lunch")){
            imageView.setImageResource(R.drawable.lunch);
            meal_item_menu_list.add(new meal_item_menu(R.drawable.l1,"Instant Lunch","fries+coke+burger","4.5","13.00-15.30","155 Rs"));
            meal_item_menu_list.add(new meal_item_menu(R.drawable.l2,"Indian Junk","Curry+Tacos+IndianBread","5.0","12.00-4.30","100 Rs"));
            meal_item_menu_list.add(new meal_item_menu(R.drawable.l3,"Vegan Lunch","Brocollie includes","4.9","13.00-15.30","130 Rs"));
            meal_item_menu_list.add(new meal_item_menu(R.drawable.l4,"Vegetable Tacos","Low fat Tacos","4.8","12.00-15.00","175 Rs"));
            meal_item_adapter.notifyDataSetChanged();
        }
        if(type != null  &&  type.equalsIgnoreCase("dinner")){
            imageView.setImageResource(R.drawable.dinner);
            meal_item_menu_list.add(new meal_item_menu(R.drawable.d1,"Subway burger","Vegetables included","4.9","19.00-22.30","145 Rs"));
            meal_item_menu_list.add(new meal_item_menu(R.drawable.d2,"Veg Pulao","Brocolli+machurian","5.0","20.00-23.30","130 Rs"));
            meal_item_menu_list.add(new meal_item_menu(R.drawable.d3,"junk dinner","burger+fries","4.7","18.00-23.30","100 Rs"));
            meal_item_menu_list.add(new meal_item_menu(R.drawable.d4,"  Aloo tikki burger","High Calories","4.8","19.00-22.00","150 Rs"));
            meal_item_adapter.notifyDataSetChanged();
        }

    }
}