package com.example.fastfood.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fastfood.R;
import com.example.fastfood.adapters.HomeHorizontalAdapter;
import com.example.fastfood.adapters.HomeVerticalAdapter;
import com.example.fastfood.adapters.UpdateVerticalRec;
import com.example.fastfood.databinding.FragmentHomeBinding;
import com.example.fastfood.modules.HomeHorizontalModule;
import com.example.fastfood.modules.HomeVerticalModule;

import java.util.ArrayList;

public class HomeFragment extends Fragment implements UpdateVerticalRec {
    RecyclerView HomeHoriRec,HomeVerRec;
    ArrayList<HomeHorizontalModule> HomeHoriModelList;
    HomeHorizontalAdapter  homeHorizontalAdapter;
    ArrayList<HomeVerticalModule> HomeVerModelList;
    HomeVerticalAdapter homeVerticalAdapter;
    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        HomeHoriRec = root.findViewById(R.id.home_hor_rec);
        HomeVerRec = root.findViewById(R.id.home_ver_rec);

        HomeHoriModelList = new ArrayList<>();
        HomeHoriModelList.add(new HomeHorizontalModule(R.drawable.pzza,"Pizza"));
        HomeHoriModelList.add(new HomeHorizontalModule(R.drawable.burger,"Burger"));
        HomeHoriModelList.add(new HomeHorizontalModule(R.drawable.frenchfries,"Fries"));
        HomeHoriModelList.add(new HomeHorizontalModule(R.drawable.sandwhich,"Sandwich"));
        HomeHoriModelList.add(new HomeHorizontalModule(R.drawable.icecream,"IceCream"));
        homeHorizontalAdapter = new HomeHorizontalAdapter(this,getActivity(),HomeHoriModelList);

        HomeHoriRec.setAdapter(homeHorizontalAdapter);
        HomeHoriRec.setHasFixedSize(true);
        HomeHoriRec.setNestedScrollingEnabled(false);
        HomeHoriRec.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false));
        // Vertical RecycleView
        HomeVerModelList = new ArrayList<>();

        homeVerticalAdapter = new HomeVerticalAdapter(getActivity(),HomeVerModelList);

        HomeVerRec.setAdapter(homeVerticalAdapter);
        HomeVerRec.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false));

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void callback(int position, ArrayList<HomeVerticalModule> list) {
        homeVerticalAdapter=new HomeVerticalAdapter(getContext(),list);
        homeVerticalAdapter.notifyDataSetChanged();
        HomeVerRec.setAdapter(homeVerticalAdapter);
    }
}