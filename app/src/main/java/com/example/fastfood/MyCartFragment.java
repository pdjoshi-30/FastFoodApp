package com.example.fastfood;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fastfood.adapters.hot_adapter;
import com.example.fastfood.adapters.mycartAdapter;
import com.example.fastfood.modules.hot_model;
import com.example.fastfood.modules.mycartModels;

import java.util.ArrayList;
import java.util.List;


public class MyCartFragment extends Fragment {
    List<mycartModels> mycartModels;
    RecyclerView recyclerView;
    mycartAdapter mycartAdapter;

    public MyCartFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_my_cart, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.cart_rec);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));

        mycartModels = new ArrayList<>();
        mycartModels.add(new mycartModels(R.drawable.bg4,"Veggie Paradise","4.9","250 Rs"));
        mycartModels.add(new mycartModels(R.drawable.ff1,"French Fries","4.7","70 Rs"));
        mycartModels.add(new mycartModels(R.drawable.ic1,"Chocolate Icecream","5.0","110 Rs"));
        mycartAdapter = new mycartAdapter(mycartModels);
        recyclerView.setAdapter(mycartAdapter);


        return view;
    }
}