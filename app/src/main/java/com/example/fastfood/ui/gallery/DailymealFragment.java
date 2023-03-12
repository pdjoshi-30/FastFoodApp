package com.example.fastfood.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fastfood.R;
import com.example.fastfood.adapters.dailymealAdapter;
import com.example.fastfood.databinding.FragmentDailymealBinding;
import com.example.fastfood.modules.dailymealModel;

import java.util.ArrayList;
import java.util.List;

public class DailymealFragment extends Fragment {
   RecyclerView recyclerView;
   List<dailymealModel> dailymealModel;
   dailymealAdapter dailymealAdapter;
    private FragmentDailymealBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        binding = FragmentDailymealBinding.inflate(inflater, container, false);

        View root = binding.getRoot();
        recyclerView = root.findViewById(R.id.daily_meal_Rec);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        dailymealModel = new ArrayList<>();
        dailymealModel.add(new dailymealModel(R.drawable.breakfast,"Breakfast","Breakfast","Click here for Description"));
        dailymealModel.add(new dailymealModel(R.drawable.lunch,"Lunch","Lunch","Click here for Description"));
        dailymealModel.add(new dailymealModel(R.drawable.dinner,"Dinner","Dinner","Click here for Description"));

        dailymealAdapter = new dailymealAdapter(getContext(),dailymealModel);
        recyclerView.setAdapter(dailymealAdapter);
        dailymealAdapter.notifyDataSetChanged();


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}