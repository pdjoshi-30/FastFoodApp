package com.example.fastfood.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fastfood.R;
import com.example.fastfood.adapters.dailymealAdapter;
import com.example.fastfood.adapters.hot_adapter;
import com.example.fastfood.adapters.hot_ver_adapters;
import com.example.fastfood.modules.hot_model;
import com.example.fastfood.modules.hot_ver_models;

import java.util.ArrayList;
import java.util.List;


public class featureFragment extends Fragment {

     List<hot_model> hot_adapter_list;
     RecyclerView recyclerView;
     hot_adapter hot_adapter;
     List<hot_ver_models> hot_ver_modelsList;
     RecyclerView recyclerView1;
     hot_ver_adapters hot_ver_adapters;


    public featureFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_feature, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.hot_hor_rec);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));

        hot_adapter_list = new ArrayList<>();
        hot_adapter_list.add(new hot_model(R.drawable.bf1,"Tea Doughnuts"));
        hot_adapter_list.add(new hot_model(R.drawable.l2,"Indian Junk"));
        hot_adapter_list.add(new hot_model(R.drawable.l4,"Tacos"));
        hot_adapter_list.add(new hot_model(R.drawable.d2,"Veg Pulao"));
        hot_adapter = new hot_adapter(hot_adapter_list);
        recyclerView.setAdapter(hot_adapter);

        RecyclerView recyclerView1 = view.findViewById(R.id.hot_ver_Rec);
        recyclerView1.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));

        hot_ver_modelsList = new ArrayList<>();
        hot_ver_modelsList.add(new hot_ver_models(R.drawable.l3,"Vegan Lunch","Brocollie includes","4.9","130 Rs"));
        hot_ver_modelsList.add(new hot_ver_models(R.drawable.l1,"Instant Lunch","fries+coke+burger","4.5","155 Rs"));
        hot_ver_modelsList.add(new hot_ver_models(R.drawable.bf2,"StrawBan Oats","No sugar","4.3","105 Rs"));
        hot_ver_modelsList.add(new hot_ver_models(R.drawable.bf4,"MayoFry","Mayo Lovers please","4.9","75 Rs"));
        hot_ver_modelsList.add(new hot_ver_models(R.drawable.d3,"junk dinner","burger+fries","4.7","100 Rs"));
        hot_ver_modelsList.add(new hot_ver_models(R.drawable.d1,"Subway burger","Vegetables included","4.9","145 Rs"));
        hot_ver_adapters = new hot_ver_adapters(hot_ver_modelsList);
        recyclerView1.setAdapter(hot_ver_adapters);

        return  view;
    }
}