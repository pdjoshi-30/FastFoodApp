package com.example.fastfood.ui.slideshow;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import com.example.fastfood.R;
import com.example.fastfood.databinding.FragmentFavBinding;
import com.example.fastfood.databinding.FragmentFavBinding;
import com.example.fastfood.fragments.featureAdapter;
import com.example.fastfood.fragments.featureFragment;
import com.google.android.material.tabs.TabLayout;

public class FavFragment extends Fragment {

    private FragmentFavBinding binding;
    TabLayout tabLayout;
    ViewPager2 viewPager2;
    featureAdapter featureAdapter;
    private FragmentActivity fragmentActivity;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentFavBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        tabLayout = root.findViewById(R.id.tab_layout);
        viewPager2 = root.findViewById(R.id.viewPager);
        FragmentManager fm = getActivity().getSupportFragmentManager();
        featureAdapter = new featureAdapter(fm,getLifecycle());
        viewPager2.setAdapter(featureAdapter);
        tabLayout.addTab(tabLayout.newTab().setText("Favourites"));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                tabLayout.selectTab(tabLayout.getTabAt(position));
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}